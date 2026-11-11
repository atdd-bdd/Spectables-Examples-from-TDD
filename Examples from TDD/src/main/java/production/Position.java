package production;

import java.util.Objects;

public class Position {
    public final String value;

    public Position(String value) {
        this.value = value != null ? value : "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        return Objects.equals(value, ((Position) o).value);
    }

    @Override
    public int hashCode() { return Objects.hash(value); }

    @Override
    public String toString() { return "Position{" + value + "}"; }
}
