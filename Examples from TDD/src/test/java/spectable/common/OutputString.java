package spectable.common;

import java.util.Objects;
import production.*;

/** Output as a table cell holds it: the unconverted text. */
public class OutputString {
    public final String value;

    public OutputString(String value) {
        this.value = value != null ? value : "";
    }

    public static OutputString fromText(String text) {
        return new OutputString(text);
    }

    @Override
    public String toString() { return value; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OutputString)) return false;
        return value.equals(((OutputString) o).value);
    }

    @Override
    public int hashCode() { return Objects.hash(value); }
}
