package production;

import java.util.Objects;

public class TennisScore {
    public final String value;

    public TennisScore(String value) {
        this.value = value != null ? value : "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TennisScore)) return false;
        return Objects.equals(value, ((TennisScore) o).value);
    }

    @Override
    public int hashCode() { return Objects.hash(value); }

    @Override
    public String toString() { return "TennisScore{" + value + "}"; }
}
