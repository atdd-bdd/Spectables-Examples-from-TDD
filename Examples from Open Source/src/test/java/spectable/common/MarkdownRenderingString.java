package spectable.common;

import java.util.Objects;

public class MarkdownRenderingString {
    private static final String DNCString = "?DNC?";

    public String markdown;
    public String html;
    public String notes;

    public MarkdownRenderingString(String markdown, String html, String notes) {
        this.markdown = markdown;
        this.html = html;
        this.notes = notes;
    }

    /** Builds from the text form, e.g. Money as "25 USD". */
    public static MarkdownRenderingString fromText(String text) {
        java.util.List<String> parts = Tokens.require(text, 3, "MarkdownRendering");
        return new MarkdownRenderingString(parts.get(0), parts.get(1), parts.get(2));
    }

    public MarkdownRenderingString(String text) {
        MarkdownRenderingString parsed = fromText(text);
        this.markdown = parsed.markdown;
        this.html = parsed.html;
        this.notes = parsed.notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MarkdownRenderingString)) return false;
        MarkdownRenderingString that = (MarkdownRenderingString) o;
        return (DNCString.equals(markdown) || DNCString.equals(that.markdown) || Objects.equals(markdown, that.markdown))
            && (DNCString.equals(html) || DNCString.equals(that.html) || Objects.equals(html, that.html))
            && (DNCString.equals(notes) || DNCString.equals(that.notes) || Objects.equals(notes, that.notes));
    }

    @Override
    public int hashCode() {
        return Objects.hash(markdown, html, notes);
    }

    @Override
    public String toString() {
        return Tokens.token(markdown) + " " + Tokens.token(html) + " " + Tokens.token(notes);
    }
}
