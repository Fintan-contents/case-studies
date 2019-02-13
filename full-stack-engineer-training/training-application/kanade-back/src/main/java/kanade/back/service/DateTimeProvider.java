package kanade.back.service;

import java.time.LocalDateTime;

/**
 * 日時情報提供クラスのインターフェース。
 *
 * @author Takahashi
 * @since 1.0
 */
public interface DateTimeProvider {

        /**
         * 現在日時を取得する。
         * @return 日時
         */
        LocalDateTime now();
}
