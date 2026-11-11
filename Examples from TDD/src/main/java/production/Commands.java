package production;

import java.util.Objects;

public class Commands {
    public final String value;

    public Commands(String value) {
        this.value = value != null ? value : "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Commands)) return false;
        return Objects.equals(value, ((Commands) o).value);
    }

    @Override
    public int hashCode() { return Objects.hash(value); }

    @Override
    public String toString() { return "Commands{" + value + "}"; }
}
