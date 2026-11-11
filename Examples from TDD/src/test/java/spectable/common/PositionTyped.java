package spectable.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import production.*;

/** Position as the glue uses it: the text read into the declared type. */
public class PositionTyped {
    private static final String DNCString = "?DNC?";

    /** The cell as written. ?DNC? and an empty cell are kept as they came. */
    public final String text;
    private final Position value;   // null for an empty cell or ?DNC?

    public PositionTyped(PositionString s) {
        this.text  = s == null ? "" : s.value;
        this.value = (text.isEmpty() || DNCString.equals(text)) ? null
                   : new Position(text);
    }

    public PositionTyped(Position value) {
        this.value = value;
        this.text  = value == null ? "" : value.toString();
    }

    public boolean hasValue() { return value != null; }

    /** The declared value, or null for an empty cell or ?DNC?. */
    public Position get() { return value; }

    public PositionString toPositionString() { return new PositionString(text); }

    public static List<PositionTyped> fromStringList(List<PositionString> list) {
        List<PositionTyped> result = new ArrayList<PositionTyped>();
        if (list != null) for (PositionString s : list) result.add(new PositionTyped(s));
        return result;
    }

    public static List<PositionString> toStringList(List<PositionTyped> list) {
        List<PositionString> result = new ArrayList<PositionString>();
        if (list != null) for (PositionTyped t : list) result.add(t.toPositionString());
        return result;
    }

    @Override
    public String toString() { return text; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PositionTyped)) return false;
        PositionTyped that = (PositionTyped) o;
        return DNCString.equals(text) || DNCString.equals(that.text)
            || Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() { return Objects.hash(text); }
}
