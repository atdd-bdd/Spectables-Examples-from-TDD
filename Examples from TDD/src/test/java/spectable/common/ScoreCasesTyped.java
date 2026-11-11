package spectable.common;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import production.*;

public class ScoreCasesTyped {
    public String rolls;
    public BowlingScoreTyped result;

    public ScoreCasesTyped(String rolls, BowlingScoreTyped result) {
        this.rolls = rolls;
        this.result = result;
    }

    public ScoreCasesTyped(ScoreCasesString s) {
        this.rolls = s.rolls;
        this.result = new BowlingScoreTyped(s.result);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ScoreCasesTyped)) return false;
        ScoreCasesTyped that = (ScoreCasesTyped) o;
        return Objects.equals(rolls, that.rolls)
            && Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rolls, result);
    }

    public ScoreCasesString toScoreCasesString() {
        return new ScoreCasesString(String.valueOf(rolls), String.valueOf(result));
    }

    public static List<ScoreCasesTyped> fromStringList(List<ScoreCasesString> list) {
        List<ScoreCasesTyped> result = new ArrayList<>();
        for (ScoreCasesString s : list) result.add(new ScoreCasesTyped(s));
        return result;
    }

    public static List<ScoreCasesString> toStringList(List<ScoreCasesTyped> list) {
        List<ScoreCasesString> result = new ArrayList<>();
        for (ScoreCasesTyped t : list) result.add(t.toScoreCasesString());
        return result;
    }

    /** Internal plumbing for {@link Json}; use toJSON() for JSON text. */
    public Map<String, Object> toJsonValue() {
        Map<String, Object> m = new LinkedHashMap<String, Object>();
        m.put("rolls", rolls);
        m.put("result", result == null ? null : result.toString());
        return m;
    }

    public String toJSON() { return Json.write(toJsonValue()); }

    /** Internal plumbing for {@link Json}; use fromJSON(String) for JSON text. */
    public static ScoreCasesTyped fromJsonValue(Map<String, Object> m) {
        if (m == null) return null;
        return new ScoreCasesTyped(
            Json.asString(Json.require(m, "rolls"), "rolls"),
            new BowlingScoreTyped(new BowlingScoreString(Json.asString(Json.require(m, "result"), "result"))));
    }

    public static ScoreCasesTyped fromJSON(String json) {
        return fromJsonValue(Json.parseObject(json));
    }

    public static String toJSONList(List<ScoreCasesTyped> list) {
        List<Object> arr = new ArrayList<Object>();
        if (list != null)
            for (ScoreCasesTyped item : list) arr.add(item == null ? null : item.toJsonValue());
        return Json.write(arr);
    }

    public static List<ScoreCasesTyped> fromJSONList(String json) {
        List<ScoreCasesTyped> result = new ArrayList<ScoreCasesTyped>();
        for (Object e : Json.parseArray(json))
            result.add(fromJsonValue(Json.asObject(e, "ScoreCasesTyped")));
        return result;
    }
}
