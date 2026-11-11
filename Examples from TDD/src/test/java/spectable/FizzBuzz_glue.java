package spectable;

import java.util.List;
import java.util.ArrayList;
import spectable.common.*;
import production.*;
import static org.junit.jupiter.api.Assertions.fail;

public class FizzBuzz_glue {
    private static final String DNCString = "?DNC?";

    public void Examples_DataType_Output(List<OutputExamplesString> values) {
        for (OutputExamplesString value : values) {
            OutputExamplesTyped typed = new OutputExamplesTyped(value);
            System.out.println(typed);
        }
        fail("Not implemented: Examples_DataType_Output");
    }

    public void Examples_Calculation_Non_Multiples_Return_Number(List<FizzBuzzCasesString> values) {
        for (FizzBuzzCasesString value : values) {
            FizzBuzzCasesTyped typed = new FizzBuzzCasesTyped(value);
            System.out.println(typed);
        }
        fail("Not implemented: Examples_Calculation_Non_Multiples_Return_Number");
    }

    public void Examples_Calculation_Multiples_Of_Three_Return_Fizz(List<FizzBuzzCasesString> values) {
        for (FizzBuzzCasesString value : values) {
            FizzBuzzCasesTyped typed = new FizzBuzzCasesTyped(value);
            System.out.println(typed);
        }
        fail("Not implemented: Examples_Calculation_Multiples_Of_Three_Return_Fizz");
    }

    public void Examples_Calculation_Multiples_Of_Five_Return_Buzz(List<FizzBuzzCasesString> values) {
        for (FizzBuzzCasesString value : values) {
            FizzBuzzCasesTyped typed = new FizzBuzzCasesTyped(value);
            System.out.println(typed);
        }
        fail("Not implemented: Examples_Calculation_Multiples_Of_Five_Return_Buzz");
    }

    public void Examples_Calculation_Multiples_Of_Three_And_Five_Return_FizzBuzz(List<FizzBuzzCasesString> values) {
        for (FizzBuzzCasesString value : values) {
            FizzBuzzCasesTyped typed = new FizzBuzzCasesTyped(value);
            System.out.println(typed);
        }
        fail("Not implemented: Examples_Calculation_Multiples_Of_Three_And_Five_Return_FizzBuzz");
    }

}
