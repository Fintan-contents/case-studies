package kanade.back.dao;

import kanade.back.dto.QuestionDto;
import kanade.back.model.Question;
import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;

/**
 * 質問のDAOインターフェース。
 *
 * @author Ko
 * @since 1.0
 */
@Dao
@ConfigAutowireable
public interface QuestionDao {

    /**
     * 全件取得する。
     *
     * @return 質問リスト
     */
    @Select
    List<QuestionDto> findAll();

    /**
     * 質問IDに紐づく質問を取得する。
     *
     * @param questionId 質問ID
     * @return 質問
     */
    @Select(ensureResult = true)
    QuestionDto findQuestionById(Integer questionId);

    /**
     * 質問を登録する。
     *
     * @param question 質問情報
     * @return 登録件数
     */
    @Insert
    int insert(Question question);
}
