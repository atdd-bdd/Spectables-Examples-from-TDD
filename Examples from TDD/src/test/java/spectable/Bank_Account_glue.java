package spectable;

import java.util.List;
import java.util.ArrayList;
import spectable.common.*;
import production.*;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Bank_Account_glue {
    private static final String DNCString = "?DNC?";

    public void Examples_DataType_Dollar(List<ValidValuesString> values) {
        for (ValidValuesString value : values) {
            boolean error = false;
            System.out.println(value);
            ValidValuesTyped vvt = new ValidValuesTyped(value);
            try {
                new Dollar(vvt.value);
            }
            catch(NumberFormatException e){
                error = true;
            }
            assertEquals(vvt.isValid.toBoolean(), !error, " Value " + vvt.value);
        }
    }

    public void Examples_DataType_ListOfDollar(List<ValidValuesString> values) {
        for (ValidValuesString value : values) {
            boolean error = false;
            System.out.println(value);
            ValidValuesTyped vvt = new ValidValuesTyped(value);
            try {
                new ListOfDollar(vvt.value);
            }
            catch(NumberFormatException e){
                error = true;
            }
            assertEquals(vvt.isValid.toBoolean(), !error, " Value " + vvt.value);
        }
    }

}
