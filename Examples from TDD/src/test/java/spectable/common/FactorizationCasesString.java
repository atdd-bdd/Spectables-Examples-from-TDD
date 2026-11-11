package spectable.common;

import java.util.Objects;
import production.*;

public class FactorizationCasesString {
    private static final String DNCString = "?DNC?";

    public String number;
    public PrimeFactorizationString result;

    public FactorizationCasesString(String number, String result) {
        this.number = number;
        this.result = new PrimeFactorizationString(result);
    }

    /** Builds from the text form, e.g. Money as "25 USD". */
    public static FactorizationCasesString fromText(String text) {
        java.util.List<String> parts = Tokens.require(text, 2, "FactorizationCases");
        return new FactorizationCasesString(parts.get(0), parts.get(1));
    }

    public FactorizationCasesString(String text) {
        FactorizationCasesString parsed = fromText(text);
        this.number = parsed.number;
        this.result = parsed.result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FactorizationCasesString)) return false;
        FactorizationCasesString that = (FactorizationCasesString) o;
        return (DNCString.equals(number) || DNCString.equals(that.number) || Objects.equals(number, that.number))
            && (DNCString.equals(result.value) || DNCString.equals(that.result.value) || Objects.equals(result.value, that.result.value));
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, result);
    }

    @Override
    public String toString() {
        return Tokens.token(number) + " " + Tokens.token(result.value);
    }
}
