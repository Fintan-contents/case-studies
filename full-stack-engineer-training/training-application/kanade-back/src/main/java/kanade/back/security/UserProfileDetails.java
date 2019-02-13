package kanade.back.security;

import kanade.back.model.UserProfile;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

/**
 * UserProfileをSpring Securityの認証で利用するためのラップクラス
 *
 * @author yoshinouchi.ryota
 * @since 1.0
 */
public class UserProfileDetails implements UserDetails {
    /** ユーザー情報 */
    UserProfile user;

    /**
     * コンストラクタ
     *
     * @param user ユーザー
     */
    public UserProfileDetails(UserProfile user) {
        this.user = user;
    }

    /**
     * ユーザー情報を返します。
     *
     * @return ユーザー
     */
    public UserProfile getUser() {
        return user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(user.getRole()));
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getMailAddress();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
