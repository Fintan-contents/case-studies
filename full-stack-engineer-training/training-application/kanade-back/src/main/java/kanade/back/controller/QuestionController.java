package kanade.back.controller;

import kanade.back.dto.QuestionAnswerSearchResultDto;
import kanade.back.dto.QuestionDto;
import kanade.back.dto.QuestionCreateDto;
import kanade.back.security.UserProfileDetails;
import kanade.back.service.QuestionService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 質問に関する情報を取得用Controller
 *
 * @author Ko
 * @since 1.0
 *
 */
@RestController
@RequestMapping("/questions")
public class QuestionController {

    /** 質問情報取得用サービス */
    private QuestionService questionService;

    /** 質問検索のコンストラクタ
     *
     * @param questionService 質問情報取得用サービス
     */
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    /**
     * 質問一覧を初期表示する。
     *
     * @return 遷移先
     */
    @RequestMapping(method=RequestMethod.GET)
    List<QuestionDto> search() {
        //全件取得
        List<QuestionDto> questionList = questionService.getQuestionList();
        return questionList;
    }

    /**
     * 質問IDに紐づく質問回答情報を取得する。
     *
     * @param questionId 表示する質問のID
     * @return 質問回答情報
     */
    @GetMapping("/{questionId}")
    QuestionAnswerSearchResultDto search(@PathVariable("questionId") Integer questionId) {
        return questionService.getQuestionAnswer(questionId);
    }

    /**
     * 質問を投稿する。
     *
     * @param dto 質問情報
     * @param userDetails ログインユーザ情報
     * @return 作成した質問の質問ID
     */
    @PostMapping
    Integer create(@Valid @RequestBody QuestionCreateDto dto, @AuthenticationPrincipal UserProfileDetails userDetails) {
        return questionService.createQuestion(dto, userDetails.getUser().getUserId());
    }
}
