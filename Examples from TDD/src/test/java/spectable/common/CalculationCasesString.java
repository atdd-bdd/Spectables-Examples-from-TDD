package spectable.common;

import java.util.Objects;
import production.*;

public class CalculationCasesString {
    private static final String DNCString = "?DNC?";

    public String input;
    public String result;

    public CalculationCasesString(String input, String result) {
        this.input = input;
        this.result = result;
    }

    /** Builds from the text form, e.g. Money as "25 USD". */
    public static CalculationCasesString fromText(String text) {
        java.util.List<String> parts = Tokens.require(text, 2, "CalculationCases");
        return new CalculationCasesString(parts.get(0), parts.get(1));
    }

    public CalculationCasesString(String text) {
        CalculationCasesString parsed = fromText(text);
        this.input = parsed.input;
        this.result = parsed.result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CalculationCasesString)) return false;
        CalculationCasesString that = (CalculationCasesString) o;
        return (DNCString.equals(input) || DNCString.equals(that.input) || Objects.equals(input, that.input))
            && (DNCString.equals(result) || DNCString.equals(that.result) || Objects.equals(result, that.result));
    }

    @Override
    public int hashCode() {
        return Objects.hash(input, result);
    }

    @Override
    public String toString() {
        return Tokens.token(input) + " " + Tokens.token(result);
    }
}
