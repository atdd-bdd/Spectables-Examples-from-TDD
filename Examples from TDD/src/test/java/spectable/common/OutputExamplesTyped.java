package spectable.common;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import production.*;

public class OutputExamplesTyped {
    public String output;

    public OutputExamplesTyped(String output) {
        this.output = output;
    }

    public OutputExamplesTyped(OutputExamplesString s) {
        this.output = s.output;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OutputExamplesTyped)) return false;
        OutputExamplesTyped that = (OutputExamplesTyped) o;
        return Objects.equals(output, that.output);
    }

    @Override
    public int hashCode() {
        return Objects.hash(output);
    }

    public OutputExamplesString toOutputExamplesString() {
        return new OutputExamplesString(String.valueOf(output));
    }

    public static List<OutputExamplesTyped> fromStringList(List<OutputExamplesString> list) {
        List<OutputExamplesTyped> result = new ArrayList<>();
        for (OutputExamplesString s : list) result.add(new OutputExamplesTyped(s));
        return result;
    }

    public static List<OutputExamplesString> toStringList(List<OutputExamplesTyped> list) {
        List<OutputExamplesString> result = new ArrayList<>();
        for (OutputExamplesTyped t : list) result.add(t.toOutputExamplesString());
        return result;
    }

    /** Internal plumbing for {@link Json}; use toJSON() for JSON text. */
    public Map<String, Object> toJsonValue() {
        Map<String, Object> m = new LinkedHashMap<String, Object>();
        m.put("output", output);
        return m;
    }

    public String toJSON() { return Json.write(toJsonValue()); }

    /** Internal plumbing for {@link Json}; use fromJSON(String) for JSON text. */
    public static OutputExamplesTyped fromJsonValue(Map<String, Object> m) {
        if (m == null) return null;
        return new OutputExamplesTyped(
            Json.asString(Json.require(m, "output"), "output"));
    }

    public static OutputExamplesTyped fromJSON(String json) {
        return fromJsonValue(Json.parseObject(json));
    }

    public static String toJSONList(List<OutputExamplesTyped> list) {
        List<Object> arr = new ArrayList<Object>();
        if (list != null)
            for (OutputExamplesTyped item : list) arr.add(item == null ? null : item.toJsonValue());
        return Json.write(arr);
    }

    public static List<OutputExamplesTyped> fromJSONList(String json) {
        List<OutputExamplesTyped> result = new ArrayList<OutputExamplesTyped>();
        for (Object e : Json.parseArray(json))
            result.add(fromJsonValue(Json.asObject(e, "OutputExamplesTyped")));
        return result;
    }
}
