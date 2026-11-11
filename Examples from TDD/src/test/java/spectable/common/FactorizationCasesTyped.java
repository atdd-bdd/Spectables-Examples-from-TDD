package spectable.common;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import production.*;

public class FactorizationCasesTyped {
    public int number;
    public PrimeFactorizationTyped result;

    public FactorizationCasesTyped(int number, PrimeFactorizationTyped result) {
        this.number = number;
        this.result = result;
    }

    public FactorizationCasesTyped(FactorizationCasesString s) {
        this.number = Integer.parseInt(s.number);
        this.result = new PrimeFactorizationTyped(s.result);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FactorizationCasesTyped)) return false;
        FactorizationCasesTyped that = (FactorizationCasesTyped) o;
        return Objects.equals(number, that.number)
            && Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, result);
    }

    public FactorizationCasesString toFactorizationCasesString() {
        return new FactorizationCasesString(String.valueOf(number), String.valueOf(result));
    }

    public static List<FactorizationCasesTyped> fromStringList(List<FactorizationCasesString> list) {
        List<FactorizationCasesTyped> result = new ArrayList<>();
        for (FactorizationCasesString s : list) result.add(new FactorizationCasesTyped(s));
        return result;
    }

    public static List<FactorizationCasesString> toStringList(List<FactorizationCasesTyped> list) {
        List<FactorizationCasesString> result = new ArrayList<>();
        for (FactorizationCasesTyped t : list) result.add(t.toFactorizationCasesString());
        return result;
    }

    /** Internal plumbing for {@link Json}; use toJSON() for JSON text. */
    public Map<String, Object> toJsonValue() {
        Map<String, Object> m = new LinkedHashMap<String, Object>();
        m.put("number", number);
        m.put("result", result == null ? null : result.toString());
        return m;
    }

    public String toJSON() { return Json.write(toJsonValue()); }

    /** Internal plumbing for {@link Json}; use fromJSON(String) for JSON text. */
    public static FactorizationCasesTyped fromJsonValue(Map<String, Object> m) {
        if (m == null) return null;
        return new FactorizationCasesTyped(
            Json.asInt(Json.require(m, "number"), "number"),
            new PrimeFactorizationTyped(new PrimeFactorizationString(Json.asString(Json.require(m, "result"), "result"))));
    }

    public static FactorizationCasesTyped fromJSON(String json) {
        return fromJsonValue(Json.parseObject(json));
    }

    public static String toJSONList(List<FactorizationCasesTyped> list) {
        List<Object> arr = new ArrayList<Object>();
        if (list != null)
            for (FactorizationCasesTyped item : list) arr.add(item == null ? null : item.toJsonValue());
        return Json.write(arr);
    }

    public static List<FactorizationCasesTyped> fromJSONList(String json) {
        List<FactorizationCasesTyped> result = new ArrayList<FactorizationCasesTyped>();
        for (Object e : Json.parseArray(json))
            result.add(fromJsonValue(Json.asObject(e, "FactorizationCasesTyped")));
        return result;
    }
}
