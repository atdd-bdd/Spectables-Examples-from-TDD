package spectable.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import production.*;

/** RomanNumeral as the glue uses it: the text read into the declared type. */
public class RomanNumeralTyped {
    private static final String DNCString = "?DNC?";

    /** The cell as written. ?DNC? and an empty cell are kept as they came. */
    public final String text;
    private final RomanNumeral value;   // null for an empty cell or ?DNC?

    public RomanNumeralTyped(RomanNumeralString s) {
        this.text  = s == null ? "" : s.value;
        this.value = (text.isEmpty() || DNCString.equals(text)) ? null
                   : new RomanNumeral(text);
    }

    public RomanNumeralTyped(RomanNumeral value) {
        this.value = value;
        this.text  = value == null ? "" : value.toString();
    }

    public boolean hasValue() { return value != null; }

    /** The declared value, or null for an empty cell or ?DNC?. */
    public RomanNumeral get() { return value; }

    public RomanNumeralString toRomanNumeralString() { return new RomanNumeralString(text); }

    public static List<RomanNumeralTyped> fromStringList(List<RomanNumeralString> list) {
        List<RomanNumeralTyped> result = new ArrayList<RomanNumeralTyped>();
        if (list != null) for (RomanNumeralString s : list) result.add(new RomanNumeralTyped(s));
        return result;
    }

    public static List<RomanNumeralString> toStringList(List<RomanNumeralTyped> list) {
        List<RomanNumeralString> result = new ArrayList<RomanNumeralString>();
        if (list != null) for (RomanNumeralTyped t : list) result.add(t.toRomanNumeralString());
        return result;
    }

    @Override
    public String toString() { return text; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RomanNumeralTyped)) return false;
        RomanNumeralTyped that = (RomanNumeralTyped) o;
        return DNCString.equals(text) || DNCString.equals(that.text)
            || Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() { return Objects.hash(text); }
}
