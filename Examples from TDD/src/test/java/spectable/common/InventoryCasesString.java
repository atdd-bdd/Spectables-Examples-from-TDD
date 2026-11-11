package spectable.common;

import java.util.Objects;
import production.*;

public class InventoryCasesString {
    private static final String DNCString = "?DNC?";

    public ItemNameString itemName;
    public String sellIn;
    public String quality;
    public String newSellIn;
    public String newQuality;
    public String notes;

    public InventoryCasesString(String itemName, String sellIn, String quality, String newSellIn, String newQuality, String notes) {
        this.itemName = new ItemNameString(itemName);
        this.sellIn = sellIn;
        this.quality = quality;
        this.newSellIn = newSellIn;
        this.newQuality = newQuality;
        this.notes = notes;
    }

    /** Builds from the text form, e.g. Money as "25 USD". */
    public static InventoryCasesString fromText(String text) {
        java.util.List<String> parts = Tokens.require(text, 6, "InventoryCases");
        return new InventoryCasesString(parts.get(0), parts.get(1), parts.get(2), parts.get(3), parts.get(4), parts.get(5));
    }

    public InventoryCasesString(String text) {
        InventoryCasesString parsed = fromText(text);
        this.itemName = parsed.itemName;
        this.sellIn = parsed.sellIn;
        this.quality = parsed.quality;
        this.newSellIn = parsed.newSellIn;
        this.newQuality = parsed.newQuality;
        this.notes = parsed.notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InventoryCasesString)) return false;
        InventoryCasesString that = (InventoryCasesString) o;
        return (DNCString.equals(itemName.value) || DNCString.equals(that.itemName.value) || Objects.equals(itemName.value, that.itemName.value))
            && (DNCString.equals(sellIn) || DNCString.equals(that.sellIn) || Objects.equals(sellIn, that.sellIn))
            && (DNCString.equals(quality) || DNCString.equals(that.quality) || Objects.equals(quality, that.quality))
            && (DNCString.equals(newSellIn) || DNCString.equals(that.newSellIn) || Objects.equals(newSellIn, that.newSellIn))
            && (DNCString.equals(newQuality) || DNCString.equals(that.newQuality) || Objects.equals(newQuality, that.newQuality))
            && (DNCString.equals(notes) || DNCString.equals(that.notes) || Objects.equals(notes, that.notes));
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemName, sellIn, quality, newSellIn, newQuality, notes);
    }

    @Override
    public String toString() {
        return Tokens.token(itemName.value) + " " + Tokens.token(sellIn) + " " + Tokens.token(quality) + " " + Tokens.token(newSellIn) + " " + Tokens.token(newQuality) + " " + Tokens.token(notes);
    }
}
