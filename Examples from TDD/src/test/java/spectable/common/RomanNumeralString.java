package spectable.common;

import java.util.Objects;
import production.*;

/** RomanNumeral as a table cell holds it: the unconverted text. */
public class RomanNumeralString {
    public final String value;

    public RomanNumeralString(String value) {
        this.value = value != null ? value : "";
    }

    public static RomanNumeralString fromText(String text) {
        return new RomanNumeralString(text);
    }

    @Override
    public String toString() { return value; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RomanNumeralString)) return false;
        return value.equals(((RomanNumeralString) o).value);
    }

    @Override
    public int hashCode() { return Objects.hash(value); }
}
