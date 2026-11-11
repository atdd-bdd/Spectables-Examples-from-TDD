package spectable.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import production.*;

/** Output as the glue uses it: the text read into the declared type. */
public class OutputTyped {
    private static final String DNCString = "?DNC?";

    /** The cell as written. ?DNC? and an empty cell are kept as they came. */
    public final String text;
    private final Output value;   // null for an empty cell or ?DNC?

    public OutputTyped(OutputString s) {
        this.text  = s == null ? "" : s.value;
        this.value = (text.isEmpty() || DNCString.equals(text)) ? null
                   : new Output(text);
    }

    public OutputTyped(Output value) {
        this.value = value;
        this.text  = value == null ? "" : value.toString();
    }

    public boolean hasValue() { return value != null; }

    /** The declared value, or null for an empty cell or ?DNC?. */
    public Output get() { return value; }

    public OutputString toOutputString() { return new OutputString(text); }

    public static List<OutputTyped> fromStringList(List<OutputString> list) {
        List<OutputTyped> result = new ArrayList<OutputTyped>();
        if (list != null) for (OutputString s : list) result.add(new OutputTyped(s));
        return result;
    }

    public static List<OutputString> toStringList(List<OutputTyped> list) {
        List<OutputString> result = new ArrayList<OutputString>();
        if (list != null) for (OutputTyped t : list) result.add(t.toOutputString());
        return result;
    }

    @Override
    public String toString() { return text; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OutputTyped)) return false;
        OutputTyped that = (OutputTyped) o;
        return DNCString.equals(text) || DNCString.equals(that.text)
            || Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() { return Objects.hash(text); }
}
