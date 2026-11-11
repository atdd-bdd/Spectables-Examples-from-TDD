package spectable.common;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import production.*;

public class LeapYearCasesTyped {
    public int year;
    public YesNo result;
    public String notes;

    public LeapYearCasesTyped(int year, YesNo result, String notes) {
        this.year = year;
        this.result = result;
        this.notes = notes;
    }

    public LeapYearCasesTyped(LeapYearCasesString s) {
        this.year = Integer.parseInt(s.year);
        this.result = new YesNo(s.result);
        this.notes = s.notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LeapYearCasesTyped)) return false;
        LeapYearCasesTyped that = (LeapYearCasesTyped) o;
        return Objects.equals(year, that.year)
            && Objects.equals(result, that.result)
            && Objects.equals(notes, that.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, result, notes);
    }

    public LeapYearCasesString toLeapYearCasesString() {
        return new LeapYearCasesString(String.valueOf(year), String.valueOf(result), String.valueOf(notes));
    }

    public static List<LeapYearCasesTyped> fromStringList(List<LeapYearCasesString> list) {
        List<LeapYearCasesTyped> result = new ArrayList<>();
        for (LeapYearCasesString s : list) result.add(new LeapYearCasesTyped(s));
        return result;
    }

    public static List<LeapYearCasesString> toStringList(List<LeapYearCasesTyped> list) {
        List<LeapYearCasesString> result = new ArrayList<>();
        for (LeapYearCasesTyped t : list) result.add(t.toLeapYearCasesString());
        return result;
    }

    /** Internal plumbing for {@link Json}; use toJSON() for JSON text. */
    public Map<String, Object> toJsonValue() {
        Map<String, Object> m = new LinkedHashMap<String, Object>();
        m.put("year", year);
        m.put("result", result == null ? null : result.value);
        m.put("notes", notes);
        return m;
    }

    public String toJSON() { return Json.write(toJsonValue()); }

    /** Internal plumbing for {@link Json}; use fromJSON(String) for JSON text. */
    public static LeapYearCasesTyped fromJsonValue(Map<String, Object> m) {
        if (m == null) return null;
        return new LeapYearCasesTyped(
            Json.asInt(Json.require(m, "year"), "year"),
            new YesNo(Json.asString(Json.require(m, "result"), "result")),
            Json.asString(Json.require(m, "notes"), "notes"));
    }

    public static LeapYearCasesTyped fromJSON(String json) {
        return fromJsonValue(Json.parseObject(json));
    }

    public static String toJSONList(List<LeapYearCasesTyped> list) {
        List<Object> arr = new ArrayList<Object>();
        if (list != null)
            for (LeapYearCasesTyped item : list) arr.add(item == null ? null : item.toJsonValue());
        return Json.write(arr);
    }

    public static List<LeapYearCasesTyped> fromJSONList(String json) {
        List<LeapYearCasesTyped> result = new ArrayList<LeapYearCasesTyped>();
        for (Object e : Json.parseArray(json))
            result.add(fromJsonValue(Json.asObject(e, "LeapYearCasesTyped")));
        return result;
    }
}
