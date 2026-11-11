package spectable.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import production.*;

/** TennisScore as the glue uses it: the text read into the declared type. */
public class TennisScoreTyped {
    private static final String DNCString = "?DNC?";

    /** The cell as written. ?DNC? and an empty cell are kept as they came. */
    public final String text;
    private final TennisScore value;   // null for an empty cell or ?DNC?

    public TennisScoreTyped(TennisScoreString s) {
        this.text  = s == null ? "" : s.value;
        this.value = (text.isEmpty() || DNCString.equals(text)) ? null
                   : new TennisScore(text);
    }

    public TennisScoreTyped(TennisScore value) {
        this.value = value;
        this.text  = value == null ? "" : value.toString();
    }

    public boolean hasValue() { return value != null; }

    /** The declared value, or null for an empty cell or ?DNC?. */
    public TennisScore get() { return value; }

    public TennisScoreString toTennisScoreString() { return new TennisScoreString(text); }

    public static List<TennisScoreTyped> fromStringList(List<TennisScoreString> list) {
        List<TennisScoreTyped> result = new ArrayList<TennisScoreTyped>();
        if (list != null) for (TennisScoreString s : list) result.add(new TennisScoreTyped(s));
        return result;
    }

    public static List<TennisScoreString> toStringList(List<TennisScoreTyped> list) {
        List<TennisScoreString> result = new ArrayList<TennisScoreString>();
        if (list != null) for (TennisScoreTyped t : list) result.add(t.toTennisScoreString());
        return result;
    }

    @Override
    public String toString() { return text; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TennisScoreTyped)) return false;
        TennisScoreTyped that = (TennisScoreTyped) o;
        return DNCString.equals(text) || DNCString.equals(that.text)
            || Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() { return Objects.hash(text); }
}
