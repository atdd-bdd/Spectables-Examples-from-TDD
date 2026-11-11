package spectable.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import production.*;

/** BowlingScore as the glue uses it: the text read into the declared type. */
public class BowlingScoreTyped {
    private static final String DNCString = "?DNC?";

    /** The cell as written. ?DNC? and an empty cell are kept as they came. */
    public final String text;
    private final BowlingScore value;   // null for an empty cell or ?DNC?

    public BowlingScoreTyped(BowlingScoreString s) {
        this.text  = s == null ? "" : s.value;
        this.value = (text.isEmpty() || DNCString.equals(text)) ? null
                   : new BowlingScore(text);
    }

    public BowlingScoreTyped(BowlingScore value) {
        this.value = value;
        this.text  = value == null ? "" : value.toString();
    }

    public boolean hasValue() { return value != null; }

    /** The declared value, or null for an empty cell or ?DNC?. */
    public BowlingScore get() { return value; }

    public BowlingScoreString toBowlingScoreString() { return new BowlingScoreString(text); }

    public static List<BowlingScoreTyped> fromStringList(List<BowlingScoreString> list) {
        List<BowlingScoreTyped> result = new ArrayList<BowlingScoreTyped>();
        if (list != null) for (BowlingScoreString s : list) result.add(new BowlingScoreTyped(s));
        return result;
    }

    public static List<BowlingScoreString> toStringList(List<BowlingScoreTyped> list) {
        List<BowlingScoreString> result = new ArrayList<BowlingScoreString>();
        if (list != null) for (BowlingScoreTyped t : list) result.add(t.toBowlingScoreString());
        return result;
    }

    @Override
    public String toString() { return text; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BowlingScoreTyped)) return false;
        BowlingScoreTyped that = (BowlingScoreTyped) o;
        return DNCString.equals(text) || DNCString.equals(that.text)
            || Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() { return Objects.hash(text); }
}
