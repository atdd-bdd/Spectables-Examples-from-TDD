package spectable.common;

import java.util.Objects;
import production.*;

public class NavigationCasesString {
    private static final String DNCString = "?DNC?";

    public PositionString startPosition;
    public CommandsString commands;
    public PositionString result;
    public String notes;

    public NavigationCasesString(String startPosition, String commands, String result, String notes) {
        this.startPosition = new PositionString(startPosition);
        this.commands = new CommandsString(commands);
        this.result = new PositionString(result);
        this.notes = notes;
    }

    /** Builds from the text form, e.g. Money as "25 USD". */
    public static NavigationCasesString fromText(String text) {
        java.util.List<String> parts = Tokens.require(text, 4, "NavigationCases");
        return new NavigationCasesString(parts.get(0), parts.get(1), parts.get(2), parts.get(3));
    }

    public NavigationCasesString(String text) {
        NavigationCasesString parsed = fromText(text);
        this.startPosition = parsed.startPosition;
        this.commands = parsed.commands;
        this.result = parsed.result;
        this.notes = parsed.notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NavigationCasesString)) return false;
        NavigationCasesString that = (NavigationCasesString) o;
        return (DNCString.equals(startPosition.value) || DNCString.equals(that.startPosition.value) || Objects.equals(startPosition.value, that.startPosition.value))
            && (DNCString.equals(commands.value) || DNCString.equals(that.commands.value) || Objects.equals(commands.value, that.commands.value))
            && (DNCString.equals(result.value) || DNCString.equals(that.result.value) || Objects.equals(result.value, that.result.value))
            && (DNCString.equals(notes) || DNCString.equals(that.notes) || Objects.equals(notes, that.notes));
    }

    @Override
    public int hashCode() {
        return Objects.hash(startPosition, commands, result, notes);
    }

    @Override
    public String toString() {
        return Tokens.token(startPosition.value) + " " + Tokens.token(commands.value) + " " + Tokens.token(result.value) + " " + Tokens.token(notes);
    }
}
