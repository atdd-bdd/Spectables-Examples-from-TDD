package spectable.common;

import java.util.Objects;
import production.*;

/** Commands as a table cell holds it: the unconverted text. */
public class CommandsString {
    public final String value;

    public CommandsString(String value) {
        this.value = value != null ? value : "";
    }

    public static CommandsString fromText(String text) {
        return new CommandsString(text);
    }

    @Override
    public String toString() { return value; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CommandsString)) return false;
        return value.equals(((CommandsString) o).value);
    }

    @Override
    public int hashCode() { return Objects.hash(value); }
}
