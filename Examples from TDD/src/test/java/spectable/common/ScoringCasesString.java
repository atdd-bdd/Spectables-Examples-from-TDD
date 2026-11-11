package spectable.common;

import java.util.Objects;
import production.*;

public class ScoringCasesString {
    private static final String DNCString = "?DNC?";

    public String player1Points;
    public String player2Points;
    public TennisScoreString result;

    public ScoringCasesString(String player1Points, String player2Points, String result) {
        this.player1Points = player1Points;
        this.player2Points = player2Points;
        this.result = new TennisScoreString(result);
    }

    /** Builds from the text form, e.g. Money as "25 USD". */
    public static ScoringCasesString fromText(String text) {
        java.util.List<String> parts = Tokens.require(text, 3, "ScoringCases");
        return new ScoringCasesString(parts.get(0), parts.get(1), parts.get(2));
    }

    public ScoringCasesString(String text) {
        ScoringCasesString parsed = fromText(text);
        this.player1Points = parsed.player1Points;
        this.player2Points = parsed.player2Points;
        this.result = parsed.result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ScoringCasesString)) return false;
        ScoringCasesString that = (ScoringCasesString) o;
        return (DNCString.equals(player1Points) || DNCString.equals(that.player1Points) || Objects.equals(player1Points, that.player1Points))
            && (DNCString.equals(player2Points) || DNCString.equals(that.player2Points) || Objects.equals(player2Points, that.player2Points))
            && (DNCString.equals(result.value) || DNCString.equals(that.result.value) || Objects.equals(result.value, that.result.value));
    }

    @Override
    public int hashCode() {
        return Objects.hash(player1Points, player2Points, result);
    }

    @Override
    public String toString() {
        return Tokens.token(player1Points) + " " + Tokens.token(player2Points) + " " + Tokens.token(result.value);
    }
}
