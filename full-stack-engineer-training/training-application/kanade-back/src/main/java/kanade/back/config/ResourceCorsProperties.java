package kanade.back.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * CORSの設定を定義するプロパティクラス
 *
 * @author yoshinouchi.ryota
 * @since 1.0
 */
@Component
@ConfigurationProperties(prefix="cors")
public class ResourceCorsProperties {

    String allowedOrigins;

    /**
     * アクセスを許可するドメインを取得する。
     * @return 許可するドメイン
     */
    public String getAllowedOrigins() {
        return allowedOrigins;
    }

    /**
     * アクセスを許可するドメインを設定する。
     * @param allowedOrigins アクセスを許可するドメイン
     */
    public void setAllowedOrigins(String allowedOrigins) {
        this.allowedOrigins = allowedOrigins;
    }
}
