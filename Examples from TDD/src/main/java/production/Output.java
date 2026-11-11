package production;

import java.util.Objects;

public class Output {
    public final String value;

    public Output(String value) {
        this.value = value != null ? value : "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Output)) return false;
        return Objects.equals(value, ((Output) o).value);
    }

    @Override
    public int hashCode() { return Objects.hash(value); }

    @Override
    public String toString() { return "Output{" + value + "}"; }
}
