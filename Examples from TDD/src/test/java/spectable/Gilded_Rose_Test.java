package spectable.tests;

import java.util.List;
import java.util.ArrayList;
import spectable.common.*;
import spectable.Gilded_Rose_glue;
import production.*;
import org.junit.jupiter.api.Test;

public class Gilded_Rose_Test {

    // -------------------------
    // DataType Tests
    // -------------------------
    @Test
    public void DataType_ItemName() {
        Gilded_Rose_glue glue = new Gilded_Rose_glue();
        List<ValidValuesString> objectList1 = new ArrayList<>();
        objectList1.add(new ValidValuesString("Dexterity Vest", "True", ""));
        objectList1.add(new ValidValuesString("Aged Brie", "True", ""));
        objectList1.add(new ValidValuesString("Sulfuras", "True", ""));
        objectList1.add(new ValidValuesString("Backstage Pass", "True", ""));
        objectList1.add(new ValidValuesString("Conjured Mana Cake", "True", ""));
        objectList1.add(new ValidValuesString("", "False", "Name must not be empty."));
        glue.Examples_DataType_ItemName(objectList1);
    }

}
