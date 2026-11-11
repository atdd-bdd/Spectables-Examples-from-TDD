package spectable.common;

import java.util.Objects;
import production.*;

/** ListOfDollar as a table cell holds it: the unconverted text. */
public class ListOfDollarString {
    public final String value;

    public ListOfDollarString(String value) {
        this.value = value != null ? value : "";
    }

    public static ListOfDollarString fromText(String text) {
        return new ListOfDollarString(text);
    }

    @Override
    public String toString() { return value; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListOfDollarString)) return false;
        return value.equals(((ListOfDollarString) o).value);
    }

    @Override
    public int hashCode() { return Objects.hash(value); }
}
