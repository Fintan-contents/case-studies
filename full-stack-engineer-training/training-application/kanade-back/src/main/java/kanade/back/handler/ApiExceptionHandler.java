package kanade.back.handler;

import org.seasar.doma.jdbc.NoResultException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.Map;

/**
 * ApiExceptionHandler
 *
 * @author Takahashi
 * @since 1.0
 */
@RestControllerAdvice
public class ApiExceptionHandler {

    /**
     * レスポンスがない場合
     * @return 返却メッセージ
     */
    @ExceptionHandler(NoResultException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleNoResult() {
        return Collections.singletonMap("message", "NOT_FOUND");
    }
}
