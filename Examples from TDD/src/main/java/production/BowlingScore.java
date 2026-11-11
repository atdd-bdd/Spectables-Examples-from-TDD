package production;

import java.util.Objects;

public class BowlingScore {
    public final String value;

    public BowlingScore(String value) {
        this.value = value != null ? value : "";
    }

    public BowlingScore(long numericValue) {
        this.value = Long.toString(numericValue);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BowlingScore)) return false;
        return Objects.equals(value, ((BowlingScore) o).value);
    }

    @Override
    public int hashCode() { return Objects.hash(value); }

    @Override
    public String toString() { return "BowlingScore{" + value + "}"; }
}
