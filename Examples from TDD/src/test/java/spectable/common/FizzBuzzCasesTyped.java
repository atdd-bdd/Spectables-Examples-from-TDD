package spectable.common;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import production.*;

public class FizzBuzzCasesTyped {
    public int number;
    public OutputTyped result;

    public FizzBuzzCasesTyped(int number, OutputTyped result) {
        this.number = number;
        this.result = result;
    }

    public FizzBuzzCasesTyped(FizzBuzzCasesString s) {
        this.number = Integer.parseInt(s.number);
        this.result = new OutputTyped(s.result);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FizzBuzzCasesTyped)) return false;
        FizzBuzzCasesTyped that = (FizzBuzzCasesTyped) o;
        return Objects.equals(number, that.number)
            && Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, result);
    }

    public FizzBuzzCasesString toFizzBuzzCasesString() {
        return new FizzBuzzCasesString(String.valueOf(number), String.valueOf(result));
    }

    public static List<FizzBuzzCasesTyped> fromStringList(List<FizzBuzzCasesString> list) {
        List<FizzBuzzCasesTyped> result = new ArrayList<>();
        for (FizzBuzzCasesString s : list) result.add(new FizzBuzzCasesTyped(s));
        return result;
    }

    public static List<FizzBuzzCasesString> toStringList(List<FizzBuzzCasesTyped> list) {
        List<FizzBuzzCasesString> result = new ArrayList<>();
        for (FizzBuzzCasesTyped t : list) result.add(t.toFizzBuzzCasesString());
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
    public static FizzBuzzCasesTyped fromJsonValue(Map<String, Object> m) {
        if (m == null) return null;
        return new FizzBuzzCasesTyped(
            Json.asInt(Json.require(m, "number"), "number"),
            new OutputTyped(new OutputString(Json.asString(Json.require(m, "result"), "result"))));
    }

    public static FizzBuzzCasesTyped fromJSON(String json) {
        return fromJsonValue(Json.parseObject(json));
    }

    public static String toJSONList(List<FizzBuzzCasesTyped> list) {
        List<Object> arr = new ArrayList<Object>();
        if (list != null)
            for (FizzBuzzCasesTyped item : list) arr.add(item == null ? null : item.toJsonValue());
        return Json.write(arr);
    }

    public static List<FizzBuzzCasesTyped> fromJSONList(String json) {
        List<FizzBuzzCasesTyped> result = new ArrayList<FizzBuzzCasesTyped>();
        for (Object e : Json.parseArray(json))
            result.add(fromJsonValue(Json.asObject(e, "FizzBuzzCasesTyped")));
        return result;
    }
}
