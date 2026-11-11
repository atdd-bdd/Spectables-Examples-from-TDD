package spectable.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import production.*;

/** ItemName as the glue uses it: the text read into the declared type. */
public class ItemNameTyped {
    private static final String DNCString = "?DNC?";

    /** The cell as written. ?DNC? and an empty cell are kept as they came. */
    public final String text;
    private final ItemName value;   // null for an empty cell or ?DNC?

    public ItemNameTyped(ItemNameString s) {
        this.text  = s == null ? "" : s.value;
        this.value = (text.isEmpty() || DNCString.equals(text)) ? null
                   : new ItemName(text);
    }

    public ItemNameTyped(ItemName value) {
        this.value = value;
        this.text  = value == null ? "" : value.toString();
    }

    public boolean hasValue() { return value != null; }

    /** The declared value, or null for an empty cell or ?DNC?. */
    public ItemName get() { return value; }

    public ItemNameString toItemNameString() { return new ItemNameString(text); }

    public static List<ItemNameTyped> fromStringList(List<ItemNameString> list) {
        List<ItemNameTyped> result = new ArrayList<ItemNameTyped>();
        if (list != null) for (ItemNameString s : list) result.add(new ItemNameTyped(s));
        return result;
    }

    public static List<ItemNameString> toStringList(List<ItemNameTyped> list) {
        List<ItemNameString> result = new ArrayList<ItemNameString>();
        if (list != null) for (ItemNameTyped t : list) result.add(t.toItemNameString());
        return result;
    }

    @Override
    public String toString() { return text; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemNameTyped)) return false;
        ItemNameTyped that = (ItemNameTyped) o;
        return DNCString.equals(text) || DNCString.equals(that.text)
            || Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() { return Objects.hash(text); }
}
