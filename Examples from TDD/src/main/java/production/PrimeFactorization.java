package production;

import java.util.Objects;

public class PrimeFactorization {
    public final String value;

    public PrimeFactorization(String value) {
        this.value = value != null ? value : "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PrimeFactorization)) return false;
        return Objects.equals(value, ((PrimeFactorization) o).value);
    }

    @Override
    public int hashCode() { return Objects.hash(value); }

    @Override
    public String toString() { return "PrimeFactorization{" + value + "}"; }
}
