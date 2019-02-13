package kanade.back.dao;

import kanade.back.model.UserProfile;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.Optional;

/**
 * ユーザー情報のDAOインターフェース
 *
 * @author yoshinouchi.ryota
 * @since 1.0
 */
@ConfigAutowireable
@Dao
public interface UserProfileDao {

    /**
     * メールアドレスを指定してユーザ情報を取得する
     *
     * @param email メールアドレス
     * @return ユーザー情報
     */
    @Select
    Optional<UserProfile> findByMailAddress(String email);
}
