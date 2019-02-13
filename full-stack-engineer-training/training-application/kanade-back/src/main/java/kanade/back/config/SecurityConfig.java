package kanade.back.config;

import javax.servlet.http.HttpServletResponse;

import kanade.back.security.JsonUsernamePasswordAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

/**
 * Spring Securityのコンフィグクラス
 *
 * @author yoshinouchi.ryota
 * @since 1.0
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    ResourceCorsProperties corsProperties;

    /**
     * コンストラクタ
     *
     * @param corsProperties CORSのプロパティを扱うクラス
     */
    public SecurityConfig(ResourceCorsProperties corsProperties) {
        this.corsProperties = corsProperties;
    }

    /**
     * APIの認証・認可制御の設定
     *
     * @param http HttpSecurity
     * @throws Exception Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // allow cross origin
        http
            .cors();

        // CSRF token off
        http
            .csrf().disable();

        // access control
        http
            .authorizeRequests()
            .mvcMatchers(HttpMethod.POST, "/questions").authenticated()
            .mvcMatchers("/users/userInfo").authenticated()
            .anyRequest().permitAll();

        // login settings
        JsonUsernamePasswordAuthenticationFilter jsonUsernamePasswordAuthenticationFilter =
            new JsonUsernamePasswordAuthenticationFilter(authenticationManager());
        jsonUsernamePasswordAuthenticationFilter.setUsernameParameter("email");
        jsonUsernamePasswordAuthenticationFilter.setPasswordParameter("password");
        // ログイン後にリダイレクトしないでいいので、AuthenticationSuccessHandlerを設定
        jsonUsernamePasswordAuthenticationFilter
            .setAuthenticationSuccessHandler((req, res, auth) -> res.setStatus(HttpServletResponse.SC_OK));
        // ログイン失敗時にリダイレクトしないでいいので、AuthenticationFailureHandlerを設定
        jsonUsernamePasswordAuthenticationFilter
            .setAuthenticationFailureHandler((req, res, ex) -> res.setStatus(HttpServletResponse.SC_UNAUTHORIZED));

        // FormログインのFilterを置き換える
        http.addFilterAt(jsonUsernamePasswordAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        // access failure handling
        // Spring Securityデフォルトでは、アクセス権限（ROLE）設定したページに未認証状態でアクセスすると403を返すので、
        // 401を返すように変更
        http.exceptionHandling().authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED));
        // 403エラー時にHTTP Bodyを返すが、これは不要なのでAccessDeniedHandlerを設定
        http.exceptionHandling().accessDeniedHandler((req, res, ex) -> res.setStatus(HttpServletResponse.SC_FORBIDDEN));

        // logout
        http
            .logout()
            .logoutUrl("/logout")
            // ログアウト時にリダイレクトしないでいいので、LogoutSuccessHandlerを設定
            .logoutSuccessHandler((req, res, auth) -> res.setStatus(HttpServletResponse.SC_OK))
            .invalidateHttpSession(true);
    }

    /**
     * CORSの設定
     * 許可するメソッド、ヘッダー、クライアントのオリジンを設定する。
     *
     * @return CORSの設定
     */
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList(corsProperties.getAllowedOrigins()));
        configuration.setAllowedMethods(Arrays.asList("OPTIONS", "DELETE", "GET", "POST", "PUT"));
        configuration.addAllowedHeader("content-type");
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
