package spectable.common;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import production.*;

public class InventoryCasesTyped {
    public ItemNameTyped itemName;
    public int sellIn;
    public int quality;
    public int newSellIn;
    public int newQuality;
    public String notes;

    public InventoryCasesTyped(ItemNameTyped itemName, int sellIn, int quality, int newSellIn, int newQuality, String notes) {
        this.itemName = itemName;
        this.sellIn = sellIn;
        this.quality = quality;
        this.newSellIn = newSellIn;
        this.newQuality = newQuality;
        this.notes = notes;
    }

    public InventoryCasesTyped(InventoryCasesString s) {
        this.itemName = new ItemNameTyped(s.itemName);
        this.sellIn = Integer.parseInt(s.sellIn);
        this.quality = Integer.parseInt(s.quality);
        this.newSellIn = Integer.parseInt(s.newSellIn);
        this.newQuality = Integer.parseInt(s.newQuality);
        this.notes = s.notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InventoryCasesTyped)) return false;
        InventoryCasesTyped that = (InventoryCasesTyped) o;
        return Objects.equals(itemName, that.itemName)
            && Objects.equals(sellIn, that.sellIn)
            && Objects.equals(quality, that.quality)
            && Objects.equals(newSellIn, that.newSellIn)
            && Objects.equals(newQuality, that.newQuality)
            && Objects.equals(notes, that.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemName, sellIn, quality, newSellIn, newQuality, notes);
    }

    public InventoryCasesString toInventoryCasesString() {
        return new InventoryCasesString(String.valueOf(itemName), String.valueOf(sellIn), String.valueOf(quality), String.valueOf(newSellIn), String.valueOf(newQuality), String.valueOf(notes));
    }

    public static List<InventoryCasesTyped> fromStringList(List<InventoryCasesString> list) {
        List<InventoryCasesTyped> result = new ArrayList<>();
        for (InventoryCasesString s : list) result.add(new InventoryCasesTyped(s));
        return result;
    }

    public static List<InventoryCasesString> toStringList(List<InventoryCasesTyped> list) {
        List<InventoryCasesString> result = new ArrayList<>();
        for (InventoryCasesTyped t : list) result.add(t.toInventoryCasesString());
        return result;
    }

    /** Internal plumbing for {@link Json}; use toJSON() for JSON text. */
    public Map<String, Object> toJsonValue() {
        Map<String, Object> m = new LinkedHashMap<String, Object>();
        m.put("itemName", itemName == null ? null : itemName.toString());
        m.put("sellIn", sellIn);
        m.put("quality", quality);
        m.put("newSellIn", newSellIn);
        m.put("newQuality", newQuality);
        m.put("notes", notes);
        return m;
    }

    public String toJSON() { return Json.write(toJsonValue()); }

    /** Internal plumbing for {@link Json}; use fromJSON(String) for JSON text. */
    public static InventoryCasesTyped fromJsonValue(Map<String, Object> m) {
        if (m == null) return null;
        return new InventoryCasesTyped(
            new ItemNameTyped(new ItemNameString(Json.asString(Json.require(m, "itemName"), "itemName"))),
            Json.asInt(Json.require(m, "sellIn"), "sellIn"),
            Json.asInt(Json.require(m, "quality"), "quality"),
            Json.asInt(Json.require(m, "newSellIn"), "newSellIn"),
            Json.asInt(Json.require(m, "newQuality"), "newQuality"),
            Json.asString(Json.require(m, "notes"), "notes"));
    }

    public static InventoryCasesTyped fromJSON(String json) {
        return fromJsonValue(Json.parseObject(json));
    }

    public static String toJSONList(List<InventoryCasesTyped> list) {
        List<Object> arr = new ArrayList<Object>();
        if (list != null)
            for (InventoryCasesTyped item : list) arr.add(item == null ? null : item.toJsonValue());
        return Json.write(arr);
    }

    public static List<InventoryCasesTyped> fromJSONList(String json) {
        List<InventoryCasesTyped> result = new ArrayList<InventoryCasesTyped>();
        for (Object e : Json.parseArray(json))
            result.add(fromJsonValue(Json.asObject(e, "InventoryCasesTyped")));
        return result;
    }
}
