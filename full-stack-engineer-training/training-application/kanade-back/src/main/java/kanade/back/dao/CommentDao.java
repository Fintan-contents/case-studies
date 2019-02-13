package kanade.back.dao;

import kanade.back.dto.AnswerDto;
import kanade.back.dto.CommentDto;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;

/**
 * コメントのDAOインターフェース。
 *
 * @author Takahashi
 * @since 1.0
 */
@Dao
@ConfigAutowireable
public interface CommentDao {

    /**
     * 親IDに紐づくコメントを全件取得する。
     *
     * @param commentType コメントタイプ
     * @param parentId 親ID
     * @return コメントDtoリスト
     */
    @Select
    List<CommentDto> findAllCommentByParentId(Integer commentType, Integer parentId);
}
