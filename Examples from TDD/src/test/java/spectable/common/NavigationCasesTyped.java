package spectable.common;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import production.*;

public class NavigationCasesTyped {
    public PositionTyped startPosition;
    public CommandsTyped commands;
    public PositionTyped result;
    public String notes;

    public NavigationCasesTyped(PositionTyped startPosition, CommandsTyped commands, PositionTyped result, String notes) {
        this.startPosition = startPosition;
        this.commands = commands;
        this.result = result;
        this.notes = notes;
    }

    public NavigationCasesTyped(NavigationCasesString s) {
        this.startPosition = new PositionTyped(s.startPosition);
        this.commands = new CommandsTyped(s.commands);
        this.result = new PositionTyped(s.result);
        this.notes = s.notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NavigationCasesTyped)) return false;
        NavigationCasesTyped that = (NavigationCasesTyped) o;
        return Objects.equals(startPosition, that.startPosition)
            && Objects.equals(commands, that.commands)
            && Objects.equals(result, that.result)
            && Objects.equals(notes, that.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startPosition, commands, result, notes);
    }

    public NavigationCasesString toNavigationCasesString() {
        return new NavigationCasesString(String.valueOf(startPosition), String.valueOf(commands), String.valueOf(result), String.valueOf(notes));
    }

    public static List<NavigationCasesTyped> fromStringList(List<NavigationCasesString> list) {
        List<NavigationCasesTyped> result = new ArrayList<>();
        for (NavigationCasesString s : list) result.add(new NavigationCasesTyped(s));
        return result;
    }

    public static List<NavigationCasesString> toStringList(List<NavigationCasesTyped> list) {
        List<NavigationCasesString> result = new ArrayList<>();
        for (NavigationCasesTyped t : list) result.add(t.toNavigationCasesString());
        return result;
    }

    /** Internal plumbing for {@link Json}; use toJSON() for JSON text. */
    public Map<String, Object> toJsonValue() {
        Map<String, Object> m = new LinkedHashMap<String, Object>();
        m.put("startPosition", startPosition == null ? null : startPosition.toString());
        m.put("commands", commands == null ? null : commands.toString());
        m.put("result", result == null ? null : result.toString());
        m.put("notes", notes);
        return m;
    }

    public String toJSON() { return Json.write(toJsonValue()); }

    /** Internal plumbing for {@link Json}; use fromJSON(String) for JSON text. */
    public static NavigationCasesTyped fromJsonValue(Map<String, Object> m) {
        if (m == null) return null;
        return new NavigationCasesTyped(
            new PositionTyped(new PositionString(Json.asString(Json.require(m, "startPosition"), "startPosition"))),
            new CommandsTyped(new CommandsString(Json.asString(Json.require(m, "commands"), "commands"))),
            new PositionTyped(new PositionString(Json.asString(Json.require(m, "result"), "result"))),
            Json.asString(Json.require(m, "notes"), "notes"));
    }

    public static NavigationCasesTyped fromJSON(String json) {
        return fromJsonValue(Json.parseObject(json));
    }

    public static String toJSONList(List<NavigationCasesTyped> list) {
        List<Object> arr = new ArrayList<Object>();
        if (list != null)
            for (NavigationCasesTyped item : list) arr.add(item == null ? null : item.toJsonValue());
        return Json.write(arr);
    }

    public static List<NavigationCasesTyped> fromJSONList(String json) {
        List<NavigationCasesTyped> result = new ArrayList<NavigationCasesTyped>();
        for (Object e : Json.parseArray(json))
            result.add(fromJsonValue(Json.asObject(e, "NavigationCasesTyped")));
        return result;
    }
}
