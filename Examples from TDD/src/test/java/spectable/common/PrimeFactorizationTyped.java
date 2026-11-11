package spectable.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import production.*;

/** PrimeFactorization as the glue uses it: the text read into the declared type. */
public class PrimeFactorizationTyped {
    private static final String DNCString = "?DNC?";

    /** The cell as written. ?DNC? and an empty cell are kept as they came. */
    public final String text;
    private final PrimeFactorization value;   // null for an empty cell or ?DNC?

    public PrimeFactorizationTyped(PrimeFactorizationString s) {
        this.text  = s == null ? "" : s.value;
        this.value = (text.isEmpty() || DNCString.equals(text)) ? null
                   : new PrimeFactorization(text);
    }

    public PrimeFactorizationTyped(PrimeFactorization value) {
        this.value = value;
        this.text  = value == null ? "" : value.toString();
    }

    public boolean hasValue() { return value != null; }

    /** The declared value, or null for an empty cell or ?DNC?. */
    public PrimeFactorization get() { return value; }

    public PrimeFactorizationString toPrimeFactorizationString() { return new PrimeFactorizationString(text); }

    public static List<PrimeFactorizationTyped> fromStringList(List<PrimeFactorizationString> list) {
        List<PrimeFactorizationTyped> result = new ArrayList<PrimeFactorizationTyped>();
        if (list != null) for (PrimeFactorizationString s : list) result.add(new PrimeFactorizationTyped(s));
        return result;
    }

    public static List<PrimeFactorizationString> toStringList(List<PrimeFactorizationTyped> list) {
        List<PrimeFactorizationString> result = new ArrayList<PrimeFactorizationString>();
        if (list != null) for (PrimeFactorizationTyped t : list) result.add(t.toPrimeFactorizationString());
        return result;
    }

    @Override
    public String toString() { return text; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PrimeFactorizationTyped)) return false;
        PrimeFactorizationTyped that = (PrimeFactorizationTyped) o;
        return DNCString.equals(text) || DNCString.equals(that.text)
            || Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() { return Objects.hash(text); }
}
