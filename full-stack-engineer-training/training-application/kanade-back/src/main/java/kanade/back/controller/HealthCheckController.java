package kanade.back.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ヘルスチェック用Controller
 *
 * @author takahashi.tetsuhiro
 * @since 1.0
 */
@RestController
public class HealthCheckController {

    /**
     * ヘルスチェックを行う。
     * @return 応答メッセージ
     */
    @GetMapping(value="/health")
    public String checkHealth() {
        return "It works.";
    }
}
