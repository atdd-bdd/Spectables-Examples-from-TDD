package spectable.common;

import java.util.Objects;
import production.*;

/** PrimeFactorization as a table cell holds it: the unconverted text. */
public class PrimeFactorizationString {
    public final String value;

    public PrimeFactorizationString(String value) {
        this.value = value != null ? value : "";
    }

    public static PrimeFactorizationString fromText(String text) {
        return new PrimeFactorizationString(text);
    }

    @Override
    public String toString() { return value; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PrimeFactorizationString)) return false;
        return value.equals(((PrimeFactorizationString) o).value);
    }

    @Override
    public int hashCode() { return Objects.hash(value); }
}
