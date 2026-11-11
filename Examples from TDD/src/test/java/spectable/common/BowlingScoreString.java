package spectable.common;

import java.util.Objects;
import production.*;

/** BowlingScore as a table cell holds it: the unconverted text. */
public class BowlingScoreString {
    public final String value;

    public BowlingScoreString(String value) {
        this.value = value != null ? value : "";
    }

    public static BowlingScoreString fromText(String text) {
        return new BowlingScoreString(text);
    }

    @Override
    public String toString() { return value; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BowlingScoreString)) return false;
        return value.equals(((BowlingScoreString) o).value);
    }

    @Override
    public int hashCode() { return Objects.hash(value); }
}
