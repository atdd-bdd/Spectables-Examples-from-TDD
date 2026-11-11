package spectable.tests;

import java.util.List;
import java.util.ArrayList;
import spectable.common.*;
import spectable.Prime_Factors_glue;
import production.*;
import org.junit.jupiter.api.Test;

public class Prime_Factors_Test {

    // -------------------------
    // Calculation Tests
    // -------------------------
    @Test
    public void Calculation_One_Has_No_Prime_Factors() {
        Prime_Factors_glue glue = new Prime_Factors_glue();
        List<FactorizationCasesString> objectList1 = new ArrayList<>();
        objectList1.add(new FactorizationCasesString("1", ""));
        glue.Examples_Calculation_One_Has_No_Prime_Factors(objectList1);
    }

    @Test
    public void Calculation_Prime_Numbers_Factor_To_Themselves() {
        Prime_Factors_glue glue = new Prime_Factors_glue();
        List<FactorizationCasesString> objectList2 = new ArrayList<>();
        objectList2.add(new FactorizationCasesString("2", "2"));
        objectList2.add(new FactorizationCasesString("3", "3"));
        objectList2.add(new FactorizationCasesString("5", "5"));
        objectList2.add(new FactorizationCasesString("7", "7"));
        objectList2.add(new FactorizationCasesString("13", "13"));
        glue.Examples_Calculation_Prime_Numbers_Factor_To_Themselves(objectList2);
    }

    @Test
    public void Calculation_Powers_Of_A_Prime() {
        Prime_Factors_glue glue = new Prime_Factors_glue();
        List<FactorizationCasesString> objectList3 = new ArrayList<>();
        objectList3.add(new FactorizationCasesString("4", "2,2"));
        objectList3.add(new FactorizationCasesString("8", "2,2,2"));
        objectList3.add(new FactorizationCasesString("9", "3,3"));
        objectList3.add(new FactorizationCasesString("27", "3,3,3"));
        glue.Examples_Calculation_Powers_Of_A_Prime(objectList3);
    }

    @Test
    public void Calculation_Composite_Numbers() {
        Prime_Factors_glue glue = new Prime_Factors_glue();
        List<FactorizationCasesString> objectList4 = new ArrayList<>();
        objectList4.add(new FactorizationCasesString("6", "2,3"));
        objectList4.add(new FactorizationCasesString("10", "2,5"));
        objectList4.add(new FactorizationCasesString("12", "2,2,3"));
        objectList4.add(new FactorizationCasesString("15", "3,5"));
        objectList4.add(new FactorizationCasesString("21", "3,7"));
        glue.Examples_Calculation_Composite_Numbers(objectList4);
    }

    @Test
    public void Calculation_Complex_Factorizations() {
        Prime_Factors_glue glue = new Prime_Factors_glue();
        List<FactorizationCasesString> objectList5 = new ArrayList<>();
        objectList5.add(new FactorizationCasesString("60", "2,2,3,5"));
        objectList5.add(new FactorizationCasesString("180", "2,2,3,3,5"));
        objectList5.add(new FactorizationCasesString("360", "2,2,2,3,3,5"));
        objectList5.add(new FactorizationCasesString("1024", "2,2,2,2,2,2,2,2,2,2"));
        glue.Examples_Calculation_Complex_Factorizations(objectList5);
    }

    // -------------------------
    // DataType Tests
    // -------------------------
    @Test
    public void DataType_PrimeFactorization() {
        Prime_Factors_glue glue = new Prime_Factors_glue();
        List<ValidValuesString> objectList6 = new ArrayList<>();
        objectList6.add(new ValidValuesString("2", "True", ""));
        objectList6.add(new ValidValuesString("2,2", "True", ""));
        objectList6.add(new ValidValuesString("2,2,3", "True", ""));
        objectList6.add(new ValidValuesString("2,2,2,3,3,5", "True", ""));
        objectList6.add(new ValidValuesString("1", "False", "1 is not a prime number."));
        objectList6.add(new ValidValuesString("4", "False", "4 is not prime and must be factored into 2,2."));
        objectList6.add(new ValidValuesString("2,4", "False", "Every factor must be prime."));
        objectList6.add(new ValidValuesString("2,3,5", "False", "Not every list of primes is a valid result."));
        objectList6.add(new ValidValuesString("", "False", "Factorization must not be empty."));
        glue.Examples_DataType_PrimeFactorization(objectList6);
    }

}
