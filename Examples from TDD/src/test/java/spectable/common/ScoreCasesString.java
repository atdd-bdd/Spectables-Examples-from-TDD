package spectable.common;

import java.util.Objects;
import production.*;

public class ScoreCasesString {
    private static final String DNCString = "?DNC?";

    public String rolls;
    public BowlingScoreString result;

    public ScoreCasesString(String rolls, String result) {
        this.rolls = rolls;
        this.result = new BowlingScoreString(result);
    }

    /** Builds from the text form, e.g. Money as "25 USD". */
    public static ScoreCasesString fromText(String text) {
        java.util.List<String> parts = Tokens.require(text, 2, "ScoreCases");
        return new ScoreCasesString(parts.get(0), parts.get(1));
    }

    public ScoreCasesString(String text) {
        ScoreCasesString parsed = fromText(text);
        this.rolls = parsed.rolls;
        this.result = parsed.result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ScoreCasesString)) return false;
        ScoreCasesString that = (ScoreCasesString) o;
        return (DNCString.equals(rolls) || DNCString.equals(that.rolls) || Objects.equals(rolls, that.rolls))
            && (DNCString.equals(result.value) || DNCString.equals(that.result.value) || Objects.equals(result.value, that.result.value));
    }

    @Override
    public int hashCode() {
        return Objects.hash(rolls, result);
    }

    @Override
    public String toString() {
        return Tokens.token(rolls) + " " + Tokens.token(result.value);
    }
}
