package spectable.common;

import java.util.Objects;
import production.*;

/** Position as a table cell holds it: the unconverted text. */
public class PositionString {
    public final String value;

    public PositionString(String value) {
        this.value = value != null ? value : "";
    }

    public static PositionString fromText(String text) {
        return new PositionString(text);
    }

    @Override
    public String toString() { return value; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PositionString)) return false;
        return value.equals(((PositionString) o).value);
    }

    @Override
    public int hashCode() { return Objects.hash(value); }
}
