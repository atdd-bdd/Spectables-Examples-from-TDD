package production;

import java.util.Objects;

public class Heading {
    public final String value;

    public Heading(String value) {
        this.value = value != null ? value : "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Heading)) return false;
        return Objects.equals(value, ((Heading) o).value);
    }

    @Override
    public int hashCode() { return Objects.hash(value); }

    @Override
    public String toString() { return "Heading{" + value + "}"; }
}
