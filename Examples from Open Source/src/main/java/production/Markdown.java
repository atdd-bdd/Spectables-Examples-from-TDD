package production;

import java.util.Objects;

public class Markdown {
    public final String value;

    public Markdown(String value) {
        this.value = value != null ? value : "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Markdown)) return false;
        return Objects.equals(value, ((Markdown) o).value);
    }

    @Override
    public int hashCode() { return Objects.hash(value); }

    @Override
    public String toString() { return "Markdown{" + value + "}"; }
}
