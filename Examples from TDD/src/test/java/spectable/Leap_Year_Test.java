package spectable.tests;

import java.util.List;
import java.util.ArrayList;
import spectable.common.*;
import spectable.Leap_Year_glue;
import production.*;
import org.junit.jupiter.api.Test;

public class Leap_Year_Test {

    // -------------------------
    // Calculation Tests
    // -------------------------
    @Test
    public void Calculation_Determine_Whether_A_Year_Is_A_Leap_Year() {
        Leap_Year_glue glue = new Leap_Year_glue();
        List<LeapYearCasesString> objectList1 = new ArrayList<>();
        objectList1.add(new LeapYearCasesString("2001", "No", "Not divisible by 4."));
        objectList1.add(new LeapYearCasesString("2002", "No", "Not divisible by 4."));
        objectList1.add(new LeapYearCasesString("2003", "No", "Not divisible by 4."));
        objectList1.add(new LeapYearCasesString("1996", "Yes", "Divisible by 4 and not a century year."));
        objectList1.add(new LeapYearCasesString("2004", "Yes", "Divisible by 4 and not a century year."));
        objectList1.add(new LeapYearCasesString("2024", "Yes", "Divisible by 4 and not a century year."));
        objectList1.add(new LeapYearCasesString("1700", "No", "Divisible by 100 but not by 400."));
        objectList1.add(new LeapYearCasesString("1800", "No", "Divisible by 100 but not by 400."));
        objectList1.add(new LeapYearCasesString("1900", "No", "Divisible by 100 but not by 400."));
        objectList1.add(new LeapYearCasesString("2000", "Yes", "Divisible by 400."));
        objectList1.add(new LeapYearCasesString("2400", "Yes", "Divisible by 400."));
        objectList1.add(new LeapYearCasesString("1999", "No", "Not divisible by 4."));
        objectList1.add(new LeapYearCasesString("2100", "No", "Divisible by 100 but not by 400."));
        glue.Examples_Calculation_Determine_Whether_A_Year_Is_A_Leap_Year(objectList1);
    }

}
