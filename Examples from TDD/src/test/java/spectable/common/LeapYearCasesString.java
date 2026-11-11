package spectable.common;

import java.util.Objects;
import production.*;

public class LeapYearCasesString {
    private static final String DNCString = "?DNC?";

    public String year;
    public String result;
    public String notes;

    public LeapYearCasesString(String year, String result, String notes) {
        this.year = year;
        this.result = result;
        this.notes = notes;
    }

    /** Builds from the text form, e.g. Money as "25 USD". */
    public static LeapYearCasesString fromText(String text) {
        java.util.List<String> parts = Tokens.require(text, 3, "LeapYearCases");
        return new LeapYearCasesString(parts.get(0), parts.get(1), parts.get(2));
    }

    public LeapYearCasesString(String text) {
        LeapYearCasesString parsed = fromText(text);
        this.year = parsed.year;
        this.result = parsed.result;
        this.notes = parsed.notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LeapYearCasesString)) return false;
        LeapYearCasesString that = (LeapYearCasesString) o;
        return (DNCString.equals(year) || DNCString.equals(that.year) || Objects.equals(year, that.year))
            && (DNCString.equals(result) || DNCString.equals(that.result) || Objects.equals(result, that.result))
            && (DNCString.equals(notes) || DNCString.equals(that.notes) || Objects.equals(notes, that.notes));
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, result, notes);
    }

    @Override
    public String toString() {
        return Tokens.token(year) + " " + Tokens.token(result) + " " + Tokens.token(notes);
    }
}
