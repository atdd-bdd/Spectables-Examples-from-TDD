package spectable.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import production.*;

/** Heading as the glue uses it: the text read into the declared type. */
public class HeadingTyped {
    private static final String DNCString = "?DNC?";

    /** The cell as written. ?DNC? and an empty cell are kept as they came. */
    public final String text;
    private final Heading value;   // null for an empty cell or ?DNC?

    public HeadingTyped(HeadingString s) {
        this.text  = s == null ? "" : s.value;
        this.value = (text.isEmpty() || DNCString.equals(text)) ? null
                   : new Heading(text);
    }

    public HeadingTyped(Heading value) {
        this.value = value;
        this.text  = value == null ? "" : value.toString();
    }

    public boolean hasValue() { return value != null; }

    /** The declared value, or null for an empty cell or ?DNC?. */
    public Heading get() { return value; }

    public HeadingString toHeadingString() { return new HeadingString(text); }

    public static List<HeadingTyped> fromStringList(List<HeadingString> list) {
        List<HeadingTyped> result = new ArrayList<HeadingTyped>();
        if (list != null) for (HeadingString s : list) result.add(new HeadingTyped(s));
        return result;
    }

    public static List<HeadingString> toStringList(List<HeadingTyped> list) {
        List<HeadingString> result = new ArrayList<HeadingString>();
        if (list != null) for (HeadingTyped t : list) result.add(t.toHeadingString());
        return result;
    }

    @Override
    public String toString() { return text; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HeadingTyped)) return false;
        HeadingTyped that = (HeadingTyped) o;
        return DNCString.equals(text) || DNCString.equals(that.text)
            || Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() { return Objects.hash(text); }
}
