package spectable.tests;

import java.util.List;
import java.util.ArrayList;
import spectable.common.*;
import spectable.Gilded_Rose_glue;
import production.*;
import org.junit.jupiter.api.Test;

public class Gilded_Rose_Test {

    // -------------------------
    // Calculation Tests
    // -------------------------
    @Test
    public void Calculation_Update_Inventory_For_One_Day() {
        Gilded_Rose_glue glue = new Gilded_Rose_glue();
        List<InventoryCasesString> objectList1 = new ArrayList<>();
        objectList1.add(new InventoryCasesString("Dexterity Vest", "10", "20", "9", "19", "Ordinary items lose one quality per day."));
        objectList1.add(new InventoryCasesString("Dexterity Vest", "0", "20", "-1", "18", "Ordinary items degrade twice as fast after sell date."));
        objectList1.add(new InventoryCasesString("Dexterity Vest", "5", "0", "4", "0", "Quality never becomes negative."));
        objectList1.add(new InventoryCasesString("Aged Brie", "10", "20", "9", "21", "Aged Brie increases in quality."));
        objectList1.add(new InventoryCasesString("Aged Brie", "0", "20", "-1", "22", "Aged Brie improves twice as fast after sell date."));
        objectList1.add(new InventoryCasesString("Aged Brie", "5", "50", "4", "50", "Quality never exceeds fifty."));
        objectList1.add(new InventoryCasesString("Sulfuras", "0", "80", "0", "80", "Legendary items never change."));
        objectList1.add(new InventoryCasesString("Sulfuras", "-1", "80", "-1", "80", "Legendary items ignore sell dates."));
        objectList1.add(new InventoryCasesString("Backstage Pass", "15", "20", "14", "21", "More than ten days remaining."));
        objectList1.add(new InventoryCasesString("Backstage Pass", "10", "20", "9", "22", "Ten or fewer days remaining."));
        objectList1.add(new InventoryCasesString("Backstage Pass", "5", "20", "4", "23", "Five or fewer days remaining."));
        objectList1.add(new InventoryCasesString("Backstage Pass", "0", "20", "-1", "0", "Quality drops to zero after concert."));
        objectList1.add(new InventoryCasesString("Conjured Mana Cake", "10", "20", "9", "18", "Conjured items degrade twice as fast."));
        objectList1.add(new InventoryCasesString("Conjured Mana Cake", "0", "20", "-1", "16", "Conjured items degrade four times as fast after sell date."));
        glue.Examples_Calculation_Update_Inventory_For_One_Day(objectList1);
    }

    // -------------------------
    // DataType Tests
    // -------------------------
    @Test
    public void DataType_ItemName() {
        Gilded_Rose_glue glue = new Gilded_Rose_glue();
        List<ValidValuesString> objectList2 = new ArrayList<>();
        objectList2.add(new ValidValuesString("Dexterity Vest", "True", ""));
        objectList2.add(new ValidValuesString("Aged Brie", "True", ""));
        objectList2.add(new ValidValuesString("Sulfuras", "True", ""));
        objectList2.add(new ValidValuesString("Backstage Pass", "True", ""));
        objectList2.add(new ValidValuesString("Conjured Mana Cake", "True", ""));
        objectList2.add(new ValidValuesString("", "False", "Name must not be empty."));
        glue.Examples_DataType_ItemName(objectList2);
    }

}
