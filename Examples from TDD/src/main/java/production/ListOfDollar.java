package production;

import java.util.Objects;

public class ListOfDollar {
    public final String value;

    public ListOfDollar(String value) {
        this.value = value != null ? value : "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListOfDollar)) return false;
        return Objects.equals(value, ((ListOfDollar) o).value);
    }

    @Override
    public int hashCode() { return Objects.hash(value); }

    @Override
    public String toString() { return "ListOfDollar{" + value + "}"; }
}
