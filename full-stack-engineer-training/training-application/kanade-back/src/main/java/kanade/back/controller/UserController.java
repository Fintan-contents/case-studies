package kanade.back.controller;

import kanade.back.config.ResourceUrlProperties;
import kanade.back.model.UserProfile;
import kanade.back.security.UserProfileDetails;
import kanade.back.service.UserProfileDetailsService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * ユーザー情報を扱うコントローラー
 *
 * @author yoshinouchi.ryota
 * @since 1.0
 */
@RestController
@RequestMapping("users")
public class UserController {

    /** ユーザー情報取得サービス */
    private UserProfileDetailsService userProfileDetailsService;

    /** 外部リソースURLの定義クラス */
    private ResourceUrlProperties url;

    /** ユーザー情報のコンストラクタ
     * @param url 外部リソースURLのプロパティクラス
     * @param userProfileDetailsService ユーザー情報取得用サービス
     */
    public UserController(ResourceUrlProperties url, UserProfileDetailsService userProfileDetailsService) {
        this.url = url;
        this.userProfileDetailsService = userProfileDetailsService;
    }

    /**
     * ログインしている場合、ログイン中のユーザー情報を返却する
     *
     * @param userDetails ログイン中のユーザー情報
     * @return ログイン中のユーザー情報
     */
    @RequestMapping(value="/userInfo", method= RequestMethod.GET)
    public Map<String, Object> getUserInfo(@AuthenticationPrincipal UserProfileDetails userDetails) {
        Map<String, Object> response = new LinkedHashMap<>();

        UserProfile user = userDetails.getUser();
        user.setImageName(userProfileDetailsService.getUserImageUrl(url, user.getImageName()));

        response.put("email", user.getMailAddress());
        response.put("firstName", user.getFirstName());
        response.put("lastName", user.getLastName());
        response.put("role", user.getRole());
        response.put("imageUrl", user.getImageName());

        return response;
    }
}
