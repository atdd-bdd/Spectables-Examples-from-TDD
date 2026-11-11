package spectable.common;

import java.util.Objects;
import production.*;

public class OutputExamplesString {
    private static final String DNCString = "?DNC?";

    public String output;

    public OutputExamplesString(String output) {
        this.output = output;
    }

    /** Builds from the text form, e.g. Money as "25 USD". */
    public static OutputExamplesString fromText(String text) {
        java.util.List<String> parts = Tokens.require(text, 1, "OutputExamples");
        return new OutputExamplesString(parts.get(0));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OutputExamplesString)) return false;
        OutputExamplesString that = (OutputExamplesString) o;
        return (DNCString.equals(output) || DNCString.equals(that.output) || Objects.equals(output, that.output));
    }

    @Override
    public int hashCode() {
        return Objects.hash(output);
    }

    @Override
    public String toString() {
        return Tokens.token(output);
    }
}
