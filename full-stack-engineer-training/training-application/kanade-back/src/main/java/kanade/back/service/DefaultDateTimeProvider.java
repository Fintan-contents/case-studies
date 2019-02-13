package kanade.back.service;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 日時情報提供クラス。
 *
 * @author Takahashi
 * @since 1.0
 */
@Component
public class DefaultDateTimeProvider implements DateTimeProvider {

    /**
     * 現在日時を取得する。
     *
     * @return システム日時
     */
    @Override
    public LocalDateTime now() {
        return LocalDateTime.now();
    }
}
