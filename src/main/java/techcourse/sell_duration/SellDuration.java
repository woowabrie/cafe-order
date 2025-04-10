package techcourse.sell_duration;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class SellDuration {

    private final LocalDateTime startInclusive;
    private final LocalDateTime endExclusive;

    public SellDuration(final LocalDateTime startInclusive, final LocalDateTime endExclusive) {
        this.startInclusive = startInclusive;
        this.endExclusive = endExclusive;
    }

    public SellDuration(final LocalDate startInclusive, final LocalDate endExclusive) {
        this.startInclusive = startInclusive.atStartOfDay();
        this.endExclusive = endExclusive.atStartOfDay();
    }

    public boolean isBetween(final LocalDateTime sellDateTime) {
        return (startInclusive.isBefore(sellDateTime) || startInclusive.isEqual(sellDateTime))
               && sellDateTime.isBefore(endExclusive);
    }
}
