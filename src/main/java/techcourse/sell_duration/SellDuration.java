package techcourse.sell_duration;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class SellDuration {

    private final LocalDateTime startInclusive;
    private final LocalDateTime endExclusive;

    public SellDuration(final LocalDateTime startInclusive, final LocalDateTime endExclusive) {
        if (startInclusive.isAfter(endExclusive)) {
            throw new IllegalArgumentException("시작 시간은 종료 시간보다 늦을 수 없습니다.");
        }
        this.startInclusive = startInclusive;
        this.endExclusive = endExclusive;
    }

    public SellDuration(final LocalDate startInclusive, final LocalDate endExclusive) {
        this(startInclusive.atStartOfDay(), endExclusive.atStartOfDay());
    }

    public boolean isBetween(final LocalDateTime sellDateTime) {
        return (startInclusive.isBefore(sellDateTime) || startInclusive.isEqual(sellDateTime))
               && sellDateTime.isBefore(endExclusive);
    }
}
