package spectable.tests;

import java.util.List;
import java.util.ArrayList;
import spectable.common.*;
import spectable.Roman_Numerals_glue;
import production.*;
import org.junit.jupiter.api.Test;

public class Roman_Numerals_Test {

    // -------------------------
    // DataType Tests
    // -------------------------
    @Test
    public void DataType_RomanNumeral() {
        Roman_Numerals_glue glue = new Roman_Numerals_glue();
        List<ValidValuesString> objectList1 = new ArrayList<>();
        objectList1.add(new ValidValuesString("I", "True", ""));
        objectList1.add(new ValidValuesString("IV", "True", ""));
        objectList1.add(new ValidValuesString("IX", "True", ""));
        objectList1.add(new ValidValuesString("XL", "True", ""));
        objectList1.add(new ValidValuesString("XCIX", "True", ""));
        objectList1.add(new ValidValuesString("MMXXIV", "True", ""));
        objectList1.add(new ValidValuesString("IIII", "False", "I cannot be repeated more than three times."));
        objectList1.add(new ValidValuesString("VV", "False", "V cannot be repeated."));
        objectList1.add(new ValidValuesString("IC", "False", "I may only precede V or X."));
        objectList1.add(new ValidValuesString("XM", "False", "X may only precede L or C."));
        objectList1.add(new ValidValuesString("", "", ""));
        glue.Examples_DataType_RomanNumeral(objectList1);
    }

}
