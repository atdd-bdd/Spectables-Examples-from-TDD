package spectable;

import java.util.List;
import java.util.ArrayList;
import spectable.common.*;
import production.*;
import static org.junit.jupiter.api.Assertions.fail;

public class Leap_Year_glue {
    private static final String DNCString = "?DNC?";


    public void Examples_Calculation_Determine_Whether_A_Year_Is_A_Leap_Year(List<LeapYearCasesString> values) {
        for (LeapYearCasesString value : values) {
            LeapYearCasesTyped typed = new LeapYearCasesTyped(value);
            System.out.println(typed);
        }
        fail("Not implemented: Examples_Calculation_Determine_Whether_A_Year_Is_A_Leap_Year");
    }

}
