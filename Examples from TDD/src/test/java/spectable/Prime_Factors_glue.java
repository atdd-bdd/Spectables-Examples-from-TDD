package spectable;

import java.util.List;
import java.util.ArrayList;
import spectable.common.*;
import production.*;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Prime_Factors_glue {
    private static final String DNCString = "?DNC?";

    public void Examples_DataType_PrimeFactorization(List<ValidValuesString> values) {
        for (ValidValuesString value : values) {
            boolean error = false;
            System.out.println(value);
            ValidValuesTyped vvt = new ValidValuesTyped(value);
            try {
                new PrimeFactorization(vvt.value);
            }
            catch(NumberFormatException e){
                error = true;
            }
            assertEquals(vvt.isValid.toBoolean(), !error, " Value " + vvt.value);
        }
    }

    public void Examples_Calculation_One_Has_No_Prime_Factors(List<FactorizationCasesString> values) {
        for (FactorizationCasesString value : values) {
            FactorizationCasesTyped typed = new FactorizationCasesTyped(value);
            System.out.println(typed);
        }
        fail("Not implemented: Examples_Calculation_One_Has_No_Prime_Factors");
    }

    public void Examples_Calculation_Prime_Numbers_Factor_To_Themselves(List<FactorizationCasesString> values) {
        for (FactorizationCasesString value : values) {
            FactorizationCasesTyped typed = new FactorizationCasesTyped(value);
            System.out.println(typed);
        }
        fail("Not implemented: Examples_Calculation_Prime_Numbers_Factor_To_Themselves");
    }

    public void Examples_Calculation_Powers_Of_A_Prime(List<FactorizationCasesString> values) {
        for (FactorizationCasesString value : values) {
            FactorizationCasesTyped typed = new FactorizationCasesTyped(value);
            System.out.println(typed);
        }
        fail("Not implemented: Examples_Calculation_Powers_Of_A_Prime");
    }

    public void Examples_Calculation_Composite_Numbers(List<FactorizationCasesString> values) {
        for (FactorizationCasesString value : values) {
            FactorizationCasesTyped typed = new FactorizationCasesTyped(value);
            System.out.println(typed);
        }
        fail("Not implemented: Examples_Calculation_Composite_Numbers");
    }

    public void Examples_Calculation_Complex_Factorizations(List<FactorizationCasesString> values) {
        for (FactorizationCasesString value : values) {
            FactorizationCasesTyped typed = new FactorizationCasesTyped(value);
            System.out.println(typed);
        }
        fail("Not implemented: Examples_Calculation_Complex_Factorizations");
    }

}
