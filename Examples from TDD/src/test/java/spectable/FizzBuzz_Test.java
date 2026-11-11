package spectable.tests;

import java.util.List;
import java.util.ArrayList;
import spectable.common.*;
import spectable.FizzBuzz_glue;
import production.*;
import org.junit.jupiter.api.Test;

public class FizzBuzz_Test {

    // -------------------------
    // Calculation Tests
    // -------------------------
    @Test
    public void Calculation_Non_Multiples_Return_Number() {
        FizzBuzz_glue glue = new FizzBuzz_glue();
        List<FizzBuzzCasesString> objectList1 = new ArrayList<>();
        objectList1.add(new FizzBuzzCasesString("1", "1"));
        objectList1.add(new FizzBuzzCasesString("2", "2"));
        objectList1.add(new FizzBuzzCasesString("4", "4"));
        objectList1.add(new FizzBuzzCasesString("7", "7"));
        objectList1.add(new FizzBuzzCasesString("8", "8"));
        glue.Examples_Calculation_Non_Multiples_Return_Number(objectList1);
    }

    @Test
    public void Calculation_Multiples_Of_Three_Return_Fizz() {
        FizzBuzz_glue glue = new FizzBuzz_glue();
        List<FizzBuzzCasesString> objectList2 = new ArrayList<>();
        objectList2.add(new FizzBuzzCasesString("3", "Fizz"));
        objectList2.add(new FizzBuzzCasesString("6", "Fizz"));
        objectList2.add(new FizzBuzzCasesString("9", "Fizz"));
        objectList2.add(new FizzBuzzCasesString("12", "Fizz"));
        glue.Examples_Calculation_Multiples_Of_Three_Return_Fizz(objectList2);
    }

    @Test
    public void Calculation_Multiples_Of_Five_Return_Buzz() {
        FizzBuzz_glue glue = new FizzBuzz_glue();
        List<FizzBuzzCasesString> objectList3 = new ArrayList<>();
        objectList3.add(new FizzBuzzCasesString("5", "Buzz"));
        objectList3.add(new FizzBuzzCasesString("10", "Buzz"));
        objectList3.add(new FizzBuzzCasesString("20", "Buzz"));
        objectList3.add(new FizzBuzzCasesString("25", "Buzz"));
        glue.Examples_Calculation_Multiples_Of_Five_Return_Buzz(objectList3);
    }

    @Test
    public void Calculation_Multiples_Of_Three_And_Five_Return_FizzBuzz() {
        FizzBuzz_glue glue = new FizzBuzz_glue();
        List<FizzBuzzCasesString> objectList4 = new ArrayList<>();
        objectList4.add(new FizzBuzzCasesString("15", "FizzBuzz"));
        objectList4.add(new FizzBuzzCasesString("30", "FizzBuzz"));
        objectList4.add(new FizzBuzzCasesString("45", "FizzBuzz"));
        objectList4.add(new FizzBuzzCasesString("60", "FizzBuzz"));
        glue.Examples_Calculation_Multiples_Of_Three_And_Five_Return_FizzBuzz(objectList4);
    }

    // -------------------------
    // DataType Tests
    // -------------------------
    @Test
    public void DataType_Output() {
        FizzBuzz_glue glue = new FizzBuzz_glue();
        List<OutputExamplesString> objectList5 = new ArrayList<>();
        objectList5.add(new OutputExamplesString("1"));
        objectList5.add(new OutputExamplesString("Fizz"));
        objectList5.add(new OutputExamplesString("Buzz"));
        objectList5.add(new OutputExamplesString("FizzBuzz"));
        glue.Examples_DataType_Output(objectList5);
    }

}
