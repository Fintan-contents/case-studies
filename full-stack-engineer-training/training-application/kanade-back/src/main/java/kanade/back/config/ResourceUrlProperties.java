package kanade.back.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 外部リソースのURLを定義するプロパティクラス
 *
 * @author Takahashi
 * @since 1.0
 */
@Component
@ConfigurationProperties(prefix="url")
public class ResourceUrlProperties {

    String userImageUrl;

    /**
     * ユーザ画像格納先のURLを取得する。
     * @return 画像格納先のURL
     */
    public String getUserImageUrl() {
        return userImageUrl;
    }

    /**
     * ユーザ画像格納先のURLを設定する。
     * @param userImageUrl 画像格納先のURL
     */
    public void setUserImageUrl(String userImageUrl) {
        this.userImageUrl = userImageUrl;
    }
}
