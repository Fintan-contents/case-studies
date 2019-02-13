package kanade.back.dao;

import kanade.back.dto.AnswerDto;
import kanade.back.dto.CommentDto;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;

/**
 * 回答のDAOインターフェース。
 *
 * @author Takahashi
 * @since 1.0
 */
@Dao
@ConfigAutowireable
public interface AnswerDao {

    /**
     * 質問IDに紐づく回答を全件取得する。
     *
     * @param questionId 質問ID
     * @return 回答Dtoリスト
     */
    @Select
    List<AnswerDto> findAllAnswerByQuestionId(Integer questionId);
}
