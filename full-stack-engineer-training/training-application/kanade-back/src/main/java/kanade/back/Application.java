package kanade.back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.SecureRandom;

/**
 * Application
 *
 * @author Takahashi
 * @since 1.0
 */
@SpringBootApplication
public class Application {

    /**
     * mainメソッド
     * @param args パラメータ
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * パスワードエンコーダ
     *
     * @return 暗号化に使用するエンコーダ
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(4, new SecureRandom());
    }
}
