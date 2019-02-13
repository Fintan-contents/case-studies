package kanade.back.dto;

import java.util.List;

/**
 * 質問回答画面表示項目検索結果格納用DTO
 *
 * @author Takahashi
 * @since 1.0
 */
public class QuestionAnswerSearchResultDto {
    /** 姓 */
    private String lastName;

    /** 名 */
    private String firstName;

    /** 画像 */
    private String imageName;

    /** 質問ID */
    private Integer questionId;

    /** 質問タイトル */
    private String title;

    /** 質問本文 */
    private String content;

    /** 作成日時 */
    private String createTime;

    /** 質問コメントリスト */
    private List<CommentDto> commentList;

    /** コメント付き回答リスト */
    private List<AnswerWithCommentDto> AnswerWithCommentDtoList;

    /**
     * 姓を返します。
     *
     * @return 姓
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * 姓を設定します。
     *
     * @param lastName 姓
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * 名を返します。
     *
     * @return 名
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * 名を設定します。
     *
     * @param firstName 名
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * アバター画像を返します。
     *
     * @return 画像
     */
    public String getImageName() {
        return imageName;
    }

    /**
     * 画像を設定します。
     *
     * @param imageName 画像
     */
    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    /**
     * 質問IDを返します。
     *
     * @return 質問ID
     */
    public Integer getQuestionId() {
        return questionId;
    }

    /**
     * 質問IDを設定します。
     *
     * @param questionId 質問ID
     */
    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    /**
     * 質問タイトルを返します。
     *
     * @return 質問タイトル
     */
    public String getTitle() {
        return title;
    }

    /**
     * 質問タイトルを設定します。
     *
     * @param title 質問タイトル
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 質問内容を返します。
     *
     * @return 質問内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 質問内容を設定します。
     *
     * @param content 質問内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 作成日時を返します。
     *
     * @return 作成日時
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * 作成日時を設定します。
     *
     * @param createTime 作成日時
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     * 質問コメントリストを返します。
     *
     * @return 質問コメントリスト
     */
    public List<CommentDto> getCommentList() {
        return commentList;
    }

    /**
     * 質問コメントリストを設定します。
     *
     * @param commentList 質問コメントリスト
     */
    public void setCommentList(List<CommentDto> commentList) {
        this.commentList = commentList;
    }

    /**
     * コメント付き回答リストを返します。
     *
     * @return コメント付き回答リスト
     */
    public List<AnswerWithCommentDto> getAnswerWithCommentDtoList() {
        return AnswerWithCommentDtoList;
    }

    /**
     * コメント付き回答リストを設定します。
     *
     * @param answerWithCommentDtoList コメント付き回答リスト
     */
    public void setAnswerWithCommentDtoList(List<AnswerWithCommentDto> answerWithCommentDtoList) {
        AnswerWithCommentDtoList = answerWithCommentDtoList;
    }
}
