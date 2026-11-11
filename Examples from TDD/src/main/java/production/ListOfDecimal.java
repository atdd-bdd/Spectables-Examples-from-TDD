package production;

import java.util.Objects;

public class ListOfDecimal {
    public final String value;

    public ListOfDecimal(String value) {
        this.value = value != null ? value : "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListOfDecimal)) return false;
        return Objects.equals(value, ((ListOfDecimal) o).value);
    }

    @Override
    public int hashCode() { return Objects.hash(value); }

    @Override
    public String toString() { return "ListOfDecimal{" + value + "}"; }
}
