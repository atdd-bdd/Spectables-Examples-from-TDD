package spectable.common;

import java.util.Objects;
import production.*;

public class FizzBuzzCasesString {
    private static final String DNCString = "?DNC?";

    public String number;
    public OutputString result;

    public FizzBuzzCasesString(String number, String result) {
        this.number = number;
        this.result = new OutputString(result);
    }

    /** Builds from the text form, e.g. Money as "25 USD". */
    public static FizzBuzzCasesString fromText(String text) {
        java.util.List<String> parts = Tokens.require(text, 2, "FizzBuzzCases");
        return new FizzBuzzCasesString(parts.get(0), parts.get(1));
    }

    public FizzBuzzCasesString(String text) {
        FizzBuzzCasesString parsed = fromText(text);
        this.number = parsed.number;
        this.result = parsed.result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FizzBuzzCasesString)) return false;
        FizzBuzzCasesString that = (FizzBuzzCasesString) o;
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
