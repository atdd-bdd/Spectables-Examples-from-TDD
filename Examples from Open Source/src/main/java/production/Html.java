package production;

import java.util.Objects;

public class Html {
    public final String value;

    public Html(String value) {
        this.value = value != null ? value : "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Html)) return false;
        return Objects.equals(value, ((Html) o).value);
    }

    @Override
    public int hashCode() { return Objects.hash(value); }

    @Override
    public String toString() { return "Html{" + value + "}"; }
}
