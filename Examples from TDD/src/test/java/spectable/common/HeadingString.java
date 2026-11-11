package spectable.common;

import java.util.Objects;
import production.*;

/** Heading as a table cell holds it: the unconverted text. */
public class HeadingString {
    public final String value;

    public HeadingString(String value) {
        this.value = value != null ? value : "";
    }

    public static HeadingString fromText(String text) {
        return new HeadingString(text);
    }

    @Override
    public String toString() { return value; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HeadingString)) return false;
        return value.equals(((HeadingString) o).value);
    }

    @Override
    public int hashCode() { return Objects.hash(value); }
}
