package spectable.common;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import production.*;

public class CalculationCasesTyped {
    public String input;
    public String result;

    public CalculationCasesTyped(String input, String result) {
        this.input = input;
        this.result = result;
    }

    public CalculationCasesTyped(CalculationCasesString s) {
        this.input = s.input;
        this.result = s.result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CalculationCasesTyped)) return false;
        CalculationCasesTyped that = (CalculationCasesTyped) o;
        return Objects.equals(input, that.input)
            && Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(input, result);
    }

    public CalculationCasesString toCalculationCasesString() {
        return new CalculationCasesString(String.valueOf(input), String.valueOf(result));
    }

    public static List<CalculationCasesTyped> fromStringList(List<CalculationCasesString> list) {
        List<CalculationCasesTyped> result = new ArrayList<>();
        for (CalculationCasesString s : list) result.add(new CalculationCasesTyped(s));
        return result;
    }

    public static List<CalculationCasesString> toStringList(List<CalculationCasesTyped> list) {
        List<CalculationCasesString> result = new ArrayList<>();
        for (CalculationCasesTyped t : list) result.add(t.toCalculationCasesString());
        return result;
    }

    /** Internal plumbing for {@link Json}; use toJSON() for JSON text. */
    public Map<String, Object> toJsonValue() {
        Map<String, Object> m = new LinkedHashMap<String, Object>();
        m.put("input", input);
        m.put("result", result);
        return m;
    }

    public String toJSON() { return Json.write(toJsonValue()); }

    /** Internal plumbing for {@link Json}; use fromJSON(String) for JSON text. */
    public static CalculationCasesTyped fromJsonValue(Map<String, Object> m) {
        if (m == null) return null;
        return new CalculationCasesTyped(
            Json.asString(Json.require(m, "input"), "input"),
            Json.asString(Json.require(m, "result"), "result"));
    }

    public static CalculationCasesTyped fromJSON(String json) {
        return fromJsonValue(Json.parseObject(json));
    }

    public static String toJSONList(List<CalculationCasesTyped> list) {
        List<Object> arr = new ArrayList<Object>();
        if (list != null)
            for (CalculationCasesTyped item : list) arr.add(item == null ? null : item.toJsonValue());
        return Json.write(arr);
    }

    public static List<CalculationCasesTyped> fromJSONList(String json) {
        List<CalculationCasesTyped> result = new ArrayList<CalculationCasesTyped>();
        for (Object e : Json.parseArray(json))
            result.add(fromJsonValue(Json.asObject(e, "CalculationCasesTyped")));
        return result;
    }
}
