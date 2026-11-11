package spectable.common;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import production.*;

public class ScoringCasesTyped {
    public int player1Points;
    public int player2Points;
    public TennisScoreTyped result;

    public ScoringCasesTyped(int player1Points, int player2Points, TennisScoreTyped result) {
        this.player1Points = player1Points;
        this.player2Points = player2Points;
        this.result = result;
    }

    public ScoringCasesTyped(ScoringCasesString s) {
        this.player1Points = Integer.parseInt(s.player1Points);
        this.player2Points = Integer.parseInt(s.player2Points);
        this.result = new TennisScoreTyped(s.result);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ScoringCasesTyped)) return false;
        ScoringCasesTyped that = (ScoringCasesTyped) o;
        return Objects.equals(player1Points, that.player1Points)
            && Objects.equals(player2Points, that.player2Points)
            && Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(player1Points, player2Points, result);
    }

    public ScoringCasesString toScoringCasesString() {
        return new ScoringCasesString(String.valueOf(player1Points), String.valueOf(player2Points), String.valueOf(result));
    }

    public static List<ScoringCasesTyped> fromStringList(List<ScoringCasesString> list) {
        List<ScoringCasesTyped> result = new ArrayList<>();
        for (ScoringCasesString s : list) result.add(new ScoringCasesTyped(s));
        return result;
    }

    public static List<ScoringCasesString> toStringList(List<ScoringCasesTyped> list) {
        List<ScoringCasesString> result = new ArrayList<>();
        for (ScoringCasesTyped t : list) result.add(t.toScoringCasesString());
        return result;
    }

    /** Internal plumbing for {@link Json}; use toJSON() for JSON text. */
    public Map<String, Object> toJsonValue() {
        Map<String, Object> m = new LinkedHashMap<String, Object>();
        m.put("player1Points", player1Points);
        m.put("player2Points", player2Points);
        m.put("result", result == null ? null : result.toString());
        return m;
    }

    public String toJSON() { return Json.write(toJsonValue()); }

    /** Internal plumbing for {@link Json}; use fromJSON(String) for JSON text. */
    public static ScoringCasesTyped fromJsonValue(Map<String, Object> m) {
        if (m == null) return null;
        return new ScoringCasesTyped(
            Json.asInt(Json.require(m, "player1Points"), "player1Points"),
            Json.asInt(Json.require(m, "player2Points"), "player2Points"),
            new TennisScoreTyped(new TennisScoreString(Json.asString(Json.require(m, "result"), "result"))));
    }

    public static ScoringCasesTyped fromJSON(String json) {
        return fromJsonValue(Json.parseObject(json));
    }

    public static String toJSONList(List<ScoringCasesTyped> list) {
        List<Object> arr = new ArrayList<Object>();
        if (list != null)
            for (ScoringCasesTyped item : list) arr.add(item == null ? null : item.toJsonValue());
        return Json.write(arr);
    }

    public static List<ScoringCasesTyped> fromJSONList(String json) {
        List<ScoringCasesTyped> result = new ArrayList<ScoringCasesTyped>();
        for (Object e : Json.parseArray(json))
            result.add(fromJsonValue(Json.asObject(e, "ScoringCasesTyped")));
        return result;
    }
}
