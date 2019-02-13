package kanade.back.security;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * 認証の設定を適用させるフィルター
 *
 * @author yoshinouchi.ryota
 * @since 1.0
 */
public class JsonUsernamePasswordAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
    ObjectMapper objectMapper = new ObjectMapper();

    String usernameParameter = "username";
    String passwordParameter = "password";

    /**
     * コンストラクタ
     *
     * @param authenticationManager authenticationManager
     */
    public JsonUsernamePasswordAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(new AntPathRequestMatcher("/login", "POST"));
        this.setAuthenticationManager(authenticationManager);
    }

    /**
     * 認証時にユーザー名として使用するリクエストパラメータ名を返します。
     *
     * @return ユーザ名のリクエストパラメータ名
     */
    public String getUsernameParameter() {
        return usernameParameter;
    }

    /**
     * 認証時にユーザー名として使用するリクエストパラメータ名を設定します。
     *
     * @param usernameParameter パラメータ名
     */
    public void setUsernameParameter(String usernameParameter) {
        this.usernameParameter = usernameParameter;
    }

    /**
     * 認証時にパスワードとして使用するリクエストパラメータ名を返します。
     *
     * @return パスワードのリクエストパラメータ名
     */
    public String getPasswordParameter() {
        return passwordParameter;
    }

    /**
     * 認証時にパスワードとして使用するリクエストパラメータ名を設定します。
     *
     * @param passwordParameter パラメータ名
     */
    public void setPasswordParameter(String passwordParameter) {
        this.passwordParameter = passwordParameter;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        Map<String, Object> requestObject;
        try {
            requestObject = objectMapper.readValue(request.getInputStream(), Map.class);
        } catch (IOException e) {
            requestObject = new HashMap<>();
        }

        String username =
                Optional
                        .ofNullable(requestObject.get(usernameParameter))
                        .map(Object::toString)
                        .map(String::trim)
                        .orElse("");
        String password =
                Optional
                        .ofNullable(requestObject.get(passwordParameter))
                        .map(Object::toString)
                        .orElse("");

        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
                username, password);

        authRequest.setDetails(authenticationDetailsSource.buildDetails(request));

        return this.getAuthenticationManager().authenticate(authRequest);
    }
}
