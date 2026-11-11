package spectable.common;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class MarkdownRenderingTyped {
    public String markdown;
    public String html;
    public String notes;

    public MarkdownRenderingTyped(String markdown, String html, String notes) {
        this.markdown = markdown;
        this.html = html;
        this.notes = notes;
    }

    public MarkdownRenderingTyped(MarkdownRenderingString s) {
        this.markdown = s.markdown;
        this.html = s.html;
        this.notes = s.notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MarkdownRenderingTyped)) return false;
        MarkdownRenderingTyped that = (MarkdownRenderingTyped) o;
        return Objects.equals(markdown, that.markdown)
            && Objects.equals(html, that.html)
            && Objects.equals(notes, that.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(markdown, html, notes);
    }

    public MarkdownRenderingString toMarkdownRenderingString() {
        return new MarkdownRenderingString(String.valueOf(markdown), String.valueOf(html), String.valueOf(notes));
    }

    public static List<MarkdownRenderingTyped> fromStringList(List<MarkdownRenderingString> list) {
        List<MarkdownRenderingTyped> result = new ArrayList<>();
        for (MarkdownRenderingString s : list) result.add(new MarkdownRenderingTyped(s));
        return result;
    }

    public static List<MarkdownRenderingString> toStringList(List<MarkdownRenderingTyped> list) {
        List<MarkdownRenderingString> result = new ArrayList<>();
        for (MarkdownRenderingTyped t : list) result.add(t.toMarkdownRenderingString());
        return result;
    }

    /** Internal plumbing for {@link Json}; use toJSON() for JSON text. */
    public Map<String, Object> toJsonValue() {
        Map<String, Object> m = new LinkedHashMap<String, Object>();
        m.put("markdown", markdown);
        m.put("html", html);
        m.put("notes", notes);
        return m;
    }

    public String toJSON() { return Json.write(toJsonValue()); }

    /** Internal plumbing for {@link Json}; use fromJSON(String) for JSON text. */
    public static MarkdownRenderingTyped fromJsonValue(Map<String, Object> m) {
        if (m == null) return null;
        return new MarkdownRenderingTyped(
            Json.asString(Json.require(m, "markdown"), "markdown"),
            Json.asString(Json.require(m, "html"), "html"),
            Json.asString(Json.require(m, "notes"), "notes"));
    }

    public static MarkdownRenderingTyped fromJSON(String json) {
        return fromJsonValue(Json.parseObject(json));
    }

    public static String toJSONList(List<MarkdownRenderingTyped> list) {
        List<Object> arr = new ArrayList<Object>();
        if (list != null)
            for (MarkdownRenderingTyped item : list) arr.add(item == null ? null : item.toJsonValue());
        return Json.write(arr);
    }

    public static List<MarkdownRenderingTyped> fromJSONList(String json) {
        List<MarkdownRenderingTyped> result = new ArrayList<MarkdownRenderingTyped>();
        for (Object e : Json.parseArray(json))
            result.add(fromJsonValue(Json.asObject(e, "MarkdownRenderingTyped")));
        return result;
    }
}
