package production;

import java.util.Objects;

public class Dollar {
    public final String value;

    public Dollar(String value) {
        this.value = value != null ? value : "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dollar)) return false;
        return Objects.equals(value, ((Dollar) o).value);
    }

    @Override
    public int hashCode() { return Objects.hash(value); }

    @Override
    public String toString() { return "Dollar{" + value + "}"; }
}
