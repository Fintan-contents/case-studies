package kanade.back.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Primary
public class MockDateTimeProvider implements DateTimeProvider {
    @Override
    public LocalDateTime now() {
        return LocalDateTime.of(2018, 11, 28, 12, 34, 56, 0);
    }
}
