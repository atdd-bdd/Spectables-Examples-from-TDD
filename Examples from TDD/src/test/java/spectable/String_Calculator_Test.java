package spectable.tests;

import java.util.List;
import java.util.ArrayList;
import spectable.common.*;
import spectable.String_Calculator_glue;
import production.*;
import org.junit.jupiter.api.Test;

public class String_Calculator_Test {

    // -------------------------
    // Calculation Tests
    // -------------------------
    @Test
    public void Calculation_Empty_String_Returns_Zero() {
        String_Calculator_glue glue = new String_Calculator_glue();
        List<CalculationCasesString> objectList1 = new ArrayList<>();
        objectList1.add(new CalculationCasesString("", "0"));
        glue.Examples_Calculation_Empty_String_Returns_Zero(objectList1);
    }

    @Test
    public void Calculation_Single_Number_Returns_Value() {
        String_Calculator_glue glue = new String_Calculator_glue();
        List<CalculationCasesString> objectList2 = new ArrayList<>();
        objectList2.add(new CalculationCasesString("1", "1"));
        objectList2.add(new CalculationCasesString("42", "42"));
        glue.Examples_Calculation_Single_Number_Returns_Value(objectList2);
    }

    @Test
    public void Calculation_Multiple_Numbers_Are_Summed() {
        String_Calculator_glue glue = new String_Calculator_glue();
        List<CalculationCasesString> objectList3 = new ArrayList<>();
        objectList3.add(new CalculationCasesString("1,2", "3"));
        objectList3.add(new CalculationCasesString("1,2,3", "6"));
        objectList3.add(new CalculationCasesString("10,20,30", "60"));
        glue.Examples_Calculation_Multiple_Numbers_Are_Summed(objectList3);
    }

    @Test
    public void Calculation_Newlines_Are_Valid_Separators() {
        String_Calculator_glue glue = new String_Calculator_glue();
        List<CalculationCasesString> objectList4 = new ArrayList<>();
        objectList4.add(new CalculationCasesString("1\\n2", "3"));
        objectList4.add(new CalculationCasesString("1\\n2,3", "6"));
        glue.Examples_Calculation_Newlines_Are_Valid_Separators(objectList4);
    }

    @Test
    public void Calculation_Custom_Delimiter_Is_Supported() {
        String_Calculator_glue glue = new String_Calculator_glue();
        List<CalculationCasesString> objectList5 = new ArrayList<>();
        objectList5.add(new CalculationCasesString("//;\\n1;2", "3"));
        objectList5.add(new CalculationCasesString("//", "0"));
        glue.Examples_Calculation_Custom_Delimiter_Is_Supported(objectList5);
    }

    @Test
    public void Calculation_Negative_Numbers_Cause_Error() {
        String_Calculator_glue glue = new String_Calculator_glue();
        List<CalculationCasesString> objectList6 = new ArrayList<>();
        objectList6.add(new CalculationCasesString("-1", "Error"));
        objectList6.add(new CalculationCasesString("1,-2", "Error"));
        objectList6.add(new CalculationCasesString("-1,-2", "Error"));
        glue.Examples_Calculation_Negative_Numbers_Cause_Error(objectList6);
    }

    @Test
    public void Calculation_Numbers_Greater_Than_One_Thousand_Are_Ignored() {
        String_Calculator_glue glue = new String_Calculator_glue();
        List<CalculationCasesString> objectList7 = new ArrayList<>();
        objectList7.add(new CalculationCasesString("2,1001", "2"));
        objectList7.add(new CalculationCasesString("1000,2", "1002"));
        objectList7.add(new CalculationCasesString("1001,2", "2"));
        glue.Examples_Calculation_Numbers_Greater_Than_One_Thousand_Are_Ignored(objectList7);
    }

    @Test
    public void Calculation_Delimiters_Of_Any_Length_Are_Supported() {
        String_Calculator_glue glue = new String_Calculator_glue();
        List<CalculationCasesString> objectList8 = new ArrayList<>();
        objectList8.add(new CalculationCasesString("//[***]\\n1***2", "3"));
        objectList8.add(new CalculationCasesString("//[--]\\n2--3", "5"));
        glue.Examples_Calculation_Delimiters_Of_Any_Length_Are_Supported(objectList8);
    }

    @Test
    public void Calculation_Multiple_Delimiters_Are_Supported() {
        String_Calculator_glue glue = new String_Calculator_glue();
        List<CalculationCasesString> objectList9 = new ArrayList<>();
        objectList9.add(new CalculationCasesString("//[*][%]\\n1*2%3", "6"));
        objectList9.add(new CalculationCasesString("//[#][@]\\n2#3@4", "9"));
        glue.Examples_Calculation_Multiple_Delimiters_Are_Supported(objectList9);
    }

}
