package spectable.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import production.*;

/** ListOfDollar as the glue uses it: the text read into the declared type. */
public class ListOfDollarTyped {
    private static final String DNCString = "?DNC?";

    /** The cell as written. ?DNC? and an empty cell are kept as they came. */
    public final String text;
    private final ListOfDollar value;   // null for an empty cell or ?DNC?

    public ListOfDollarTyped(ListOfDollarString s) {
        this.text  = s == null ? "" : s.value;
        this.value = (text.isEmpty() || DNCString.equals(text)) ? null
                   : new ListOfDollar(text);
    }

    public ListOfDollarTyped(ListOfDollar value) {
        this.value = value;
        this.text  = value == null ? "" : value.toString();
    }

    public boolean hasValue() { return value != null; }

    /** The declared value, or null for an empty cell or ?DNC?. */
    public ListOfDollar get() { return value; }

    public ListOfDollarString toListOfDollarString() { return new ListOfDollarString(text); }

    public static List<ListOfDollarTyped> fromStringList(List<ListOfDollarString> list) {
        List<ListOfDollarTyped> result = new ArrayList<ListOfDollarTyped>();
        if (list != null) for (ListOfDollarString s : list) result.add(new ListOfDollarTyped(s));
        return result;
    }

    public static List<ListOfDollarString> toStringList(List<ListOfDollarTyped> list) {
        List<ListOfDollarString> result = new ArrayList<ListOfDollarString>();
        if (list != null) for (ListOfDollarTyped t : list) result.add(t.toListOfDollarString());
        return result;
    }

    @Override
    public String toString() { return text; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListOfDollarTyped)) return false;
        ListOfDollarTyped that = (ListOfDollarTyped) o;
        return DNCString.equals(text) || DNCString.equals(that.text)
            || Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() { return Objects.hash(text); }
}
