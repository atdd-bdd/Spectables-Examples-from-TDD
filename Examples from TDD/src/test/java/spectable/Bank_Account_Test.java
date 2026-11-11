package spectable.tests;

import java.util.List;
import java.util.ArrayList;
import spectable.common.*;
import spectable.Bank_Account_glue;
import production.*;
import org.junit.jupiter.api.Test;

public class Bank_Account_Test {

    // -------------------------
    // DataType Tests
    // -------------------------
    @Test
    public void DataType_Dollar() {
        Bank_Account_glue glue = new Bank_Account_glue();
        List<ValidValuesString> objectList1 = new ArrayList<>();
        objectList1.add(new ValidValuesString("$0.00", "True", ""));
        objectList1.add(new ValidValuesString("$1.00", "True", ""));
        objectList1.add(new ValidValuesString("$100.50", "True", ""));
        objectList1.add(new ValidValuesString("$-25.75", "True", "Negative amounts are allowed."));
        objectList1.add(new ValidValuesString("100.00", "False", "Dollar values must begin with $."));
        objectList1.add(new ValidValuesString("$12.345", "False", "More than two decimal places."));
        objectList1.add(new ValidValuesString("$ABC", "False", "Not a numeric amount."));
        objectList1.add(new ValidValuesString("$", "False", "Amount is missing."));
        glue.Examples_DataType_Dollar(objectList1);
    }

    @Test
    public void DataType_ListOfDollar() {
        Bank_Account_glue glue = new Bank_Account_glue();
        List<ValidValuesString> objectList2 = new ArrayList<>();
        objectList2.add(new ValidValuesString("", "True", "Empty list."));
        objectList2.add(new ValidValuesString("$100.00", "True", "Single value."));
        objectList2.add(new ValidValuesString("$100.00,$50.00", "True", "Multiple values."));
        objectList2.add(new ValidValuesString("$-25.00", "True", "Negative values are allowed."));
        objectList2.add(new ValidValuesString("$100.00,$-25.00,$50.00", "True", "Mixed"));
        glue.Examples_DataType_ListOfDollar(objectList2);
    }

}
