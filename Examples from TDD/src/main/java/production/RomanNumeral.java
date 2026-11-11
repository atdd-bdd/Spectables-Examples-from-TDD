package production;

import java.util.Objects;

public class RomanNumeral {
    public final String value;

    public RomanNumeral(String value) {
        this.value = value != null ? value : "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RomanNumeral)) return false;
        return Objects.equals(value, ((RomanNumeral) o).value);
    }

    @Override
    public int hashCode() { return Objects.hash(value); }

    @Override
    public String toString() { return "RomanNumeral{" + value + "}"; }
}
