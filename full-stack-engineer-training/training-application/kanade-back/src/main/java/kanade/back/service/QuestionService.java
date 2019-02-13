package kanade.back.service;

import kanade.back.config.ResourceUrlProperties;
import kanade.back.dao.AnswerDao;
import kanade.back.dao.CommentDao;
import kanade.back.dao.QuestionDao;
import kanade.back.dto.*;
import kanade.back.model.Question;
import org.seasar.doma.jdbc.NoResultException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 質問に関する情報を取得用サービス。
 *
 * @author Ko
 * @since 1.0
 */
@Service
public class QuestionService {

    /** コメントタイプ：質問 */
    private static final Integer COMMENT_TYPE_QUESTION = 0;

    /** コメントタイプ：回答 */
    private static final Integer COMMENT_TYPE_ANSWER = 1;

    /** 質問Dao */
    private QuestionDao questionDao;

    /** 回答Dao */
    private AnswerDao answerDao;

    /** コメントDao */
    private CommentDao commentDao;

    /** ユーザー情報取得サービス */
    private UserProfileDetailsService userProfileDetailsService;

    /** 外部リソースURLの定義クラス */
    private ResourceUrlProperties url;

    /** 日時提供クラス */
    private DateTimeProvider dateTimeProvider;

    /**
     * 質問回答取得サービスのコンストラクタ
     * @param questionDao 質問情報検索用Dao
     * @param answerDao 回答用Dao
     * @param commentDao コメント用Dao
     * @param url 外部リソースURLのプロパティクラス
     * @param dateTimeProvider 日時情報提供クラス
     * @param userProfileDetailsService ユーザー情報取得サービス
     */
    public QuestionService(QuestionDao questionDao,
                           AnswerDao answerDao,
                           CommentDao commentDao,
                           ResourceUrlProperties url,
                           DateTimeProvider dateTimeProvider,
                           UserProfileDetailsService userProfileDetailsService) {
        this.questionDao = questionDao;
        this.answerDao = answerDao;
        this.commentDao = commentDao;
        this.url = url;
        this.dateTimeProvider = dateTimeProvider;
        this.userProfileDetailsService = userProfileDetailsService;
    }

    /**
     * 質問一覧を取得する。
     *
     * @return 質問一覧のリスト
     */
    public List<QuestionDto> getQuestionList() {
        List<QuestionDto> questionDto = questionDao.findAll();
        for (QuestionDto dto : questionDto){
            dto.setImageName(userProfileDetailsService.getUserImageUrl(url, dto.getImageName()));
        }
        return questionDto;
    }

    /**
     * 質問IDに紐づく質問、回答、コメント情報を取得する。
     *
     * @param questionId 質問ID
     * @throws NoResultException エラー
     * @return 質問回答情報
     */
    public QuestionAnswerSearchResultDto getQuestionAnswer(Integer questionId) throws NoResultException {

        QuestionAnswerSearchResultDto result = new QuestionAnswerSearchResultDto();

        // 質問情報取得
        QuestionDto questionDto = questionDao.findQuestionById(questionId);
        BeanUtils.copyProperties(questionDto,result);
        result.setCommentList(commentDao.findAllCommentByParentId(COMMENT_TYPE_QUESTION, questionId));
        // 質問者画像URL設定
        result.setImageName(userProfileDetailsService.getUserImageUrl(url, questionDto.getImageName()));

        // 回答情報取得
        List<AnswerWithCommentDto> answerWithCommentDtoList = new ArrayList<AnswerWithCommentDto>();

        List<AnswerDto> answerList = answerDao.findAllAnswerByQuestionId(questionId);
        for(AnswerDto dto : answerList) {
            AnswerWithCommentDto answerWithCommentDto = new AnswerWithCommentDto();
            BeanUtils.copyProperties(dto, answerWithCommentDto);
            // 回答に対するコメントリスト取得
            answerWithCommentDto.setCommentList(commentDao.findAllCommentByParentId(COMMENT_TYPE_ANSWER, dto.getAnswerId()));
            // 回答者画像URL設定
            answerWithCommentDto.setImageName(userProfileDetailsService.getUserImageUrl(url, dto.getImageName()));

            answerWithCommentDtoList.add(answerWithCommentDto);
        }
        result.setAnswerWithCommentDtoList(answerWithCommentDtoList);

        return result;
    }

    /**
     * 質問を登録する。
     *
     * @param dto 質問情報
     * @param createUserId 登録ユーザID
     * @return 登録時に自動採番された質問ID
     */
    public Integer createQuestion(QuestionCreateDto dto, int createUserId) {
        // 登録時に必要な追加情報をエンティティに設定
        LocalDateTime createTime = dateTimeProvider.now();
        Question questionEntity = new Question();
        questionEntity.setTitle(dto.getTitle());
        questionEntity.setContent(dto.getContent());
        questionEntity.setCreateUserId(createUserId);
        questionEntity.setCreateTime(createTime);
        questionEntity.setUpdateTime(createTime);

        questionDao.insert(questionEntity);

        return questionEntity.getQuestionId();
    }

}
