package spectable.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import production.*;

/** Commands as the glue uses it: the text read into the declared type. */
public class CommandsTyped {
    private static final String DNCString = "?DNC?";

    /** The cell as written. ?DNC? and an empty cell are kept as they came. */
    public final String text;
    private final Commands value;   // null for an empty cell or ?DNC?

    public CommandsTyped(CommandsString s) {
        this.text  = s == null ? "" : s.value;
        this.value = (text.isEmpty() || DNCString.equals(text)) ? null
                   : new Commands(text);
    }

    public CommandsTyped(Commands value) {
        this.value = value;
        this.text  = value == null ? "" : value.toString();
    }

    public boolean hasValue() { return value != null; }

    /** The declared value, or null for an empty cell or ?DNC?. */
    public Commands get() { return value; }

    public CommandsString toCommandsString() { return new CommandsString(text); }

    public static List<CommandsTyped> fromStringList(List<CommandsString> list) {
        List<CommandsTyped> result = new ArrayList<CommandsTyped>();
        if (list != null) for (CommandsString s : list) result.add(new CommandsTyped(s));
        return result;
    }

    public static List<CommandsString> toStringList(List<CommandsTyped> list) {
        List<CommandsString> result = new ArrayList<CommandsString>();
        if (list != null) for (CommandsTyped t : list) result.add(t.toCommandsString());
        return result;
    }

    @Override
    public String toString() { return text; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CommandsTyped)) return false;
        CommandsTyped that = (CommandsTyped) o;
        return DNCString.equals(text) || DNCString.equals(that.text)
            || Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() { return Objects.hash(text); }
}
