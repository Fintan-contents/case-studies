package kanade.back.service;

import kanade.back.config.ResourceUrlProperties;
import kanade.back.dao.UserProfileDao;
import kanade.back.security.UserProfileDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/**
 * 認証に使用するユーザー情報のサービス
 *
 * @author yoshinouchi.ryota
 * @since 1.0
 */
@Service
public class UserProfileDetailsService implements UserDetailsService {
    /** ユーザー情報Dao */
    UserProfileDao userDao;

    /**
     * コンストラクタ
     *
     * @param userDao ユーザー情報のDAO
     */
    public UserProfileDetailsService(UserProfileDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDao
            .findByMailAddress(username)
            .map(u -> new UserProfileDetails(u))
            .orElseThrow(() -> new UsernameNotFoundException("not found"));
    }

    /**
     * 画像のURL変更処理。
     * @param url 外部リソースURLのプロパティクラス
     * @param imageName 画像名
     * @return 画像のURL
     */
    public String getUserImageUrl(ResourceUrlProperties url, String imageName) {
        StringBuilder imageUrl = new StringBuilder();
        imageUrl.append(url.getUserImageUrl());
        imageUrl.append(imageName);

        return imageUrl.toString();
    }
}
