package spectable.common;

import java.util.Objects;
import production.*;

/** TennisScore as a table cell holds it: the unconverted text. */
public class TennisScoreString {
    public final String value;

    public TennisScoreString(String value) {
        this.value = value != null ? value : "";
    }

    public static TennisScoreString fromText(String text) {
        return new TennisScoreString(text);
    }

    @Override
    public String toString() { return value; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TennisScoreString)) return false;
        return value.equals(((TennisScoreString) o).value);
    }

    @Override
    public int hashCode() { return Objects.hash(value); }
}
