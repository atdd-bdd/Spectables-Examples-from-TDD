package spectable.common;

import java.util.Objects;
import production.*;

/** ItemName as a table cell holds it: the unconverted text. */
public class ItemNameString {
    public final String value;

    public ItemNameString(String value) {
        this.value = value != null ? value : "";
    }

    public static ItemNameString fromText(String text) {
        return new ItemNameString(text);
    }

    @Override
    public String toString() { return value; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemNameString)) return false;
        return value.equals(((ItemNameString) o).value);
    }

    @Override
    public int hashCode() { return Objects.hash(value); }
}
