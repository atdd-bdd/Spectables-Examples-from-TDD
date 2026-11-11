package spectable;

import java.util.List;
import java.util.ArrayList;
import spectable.common.*;
import production.*;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Bowling_Game_glue {
    private static final String DNCString = "?DNC?";

    public void Examples_DataType_BowlingScore(List<ValidValuesString> values) {
        for (ValidValuesString value : values) {
            boolean error = false;
            System.out.println(value);
            ValidValuesTyped vvt = new ValidValuesTyped(value);
            try {
                new BowlingScore(vvt.value);
            }
            catch(NumberFormatException e){
                error = true;
            }
            assertEquals(vvt.isValid.toBoolean(), !error, " Value " + vvt.value);
        }
    }

    public void Examples_Calculation_Gutter_Game(List<ScoreCasesString> values) {
        for (ScoreCasesString value : values) {
            ScoreCasesTyped typed = new ScoreCasesTyped(value);
            System.out.println(typed);
        }
        fail("Not implemented: Examples_Calculation_Gutter_Game");
    }

    public void Examples_Calculation_All_Ones(List<ScoreCasesString> values) {
        for (ScoreCasesString value : values) {
            ScoreCasesTyped typed = new ScoreCasesTyped(value);
            System.out.println(typed);
        }
        fail("Not implemented: Examples_Calculation_All_Ones");
    }

    public void Examples_Calculation_Single_Spare(List<ScoreCasesString> values) {
        for (ScoreCasesString value : values) {
            ScoreCasesTyped typed = new ScoreCasesTyped(value);
            System.out.println(typed);
        }
        fail("Not implemented: Examples_Calculation_Single_Spare");
    }

    public void Examples_Calculation_Multiple_Spares(List<ScoreCasesString> values) {
        for (ScoreCasesString value : values) {
            ScoreCasesTyped typed = new ScoreCasesTyped(value);
            System.out.println(typed);
        }
        fail("Not implemented: Examples_Calculation_Multiple_Spares");
    }

    public void Examples_Calculation_Single_Strike(List<ScoreCasesString> values) {
        for (ScoreCasesString value : values) {
            ScoreCasesTyped typed = new ScoreCasesTyped(value);
            System.out.println(typed);
        }
        fail("Not implemented: Examples_Calculation_Single_Strike");
    }

    public void Examples_Calculation_Consecutive_Strikes(List<ScoreCasesString> values) {
        for (ScoreCasesString value : values) {
            ScoreCasesTyped typed = new ScoreCasesTyped(value);
            System.out.println(typed);
        }
        fail("Not implemented: Examples_Calculation_Consecutive_Strikes");
    }

    public void Examples_Calculation_Perfect_Game(List<ScoreCasesString> values) {
        for (ScoreCasesString value : values) {
            ScoreCasesTyped typed = new ScoreCasesTyped(value);
            System.out.println(typed);
        }
        fail("Not implemented: Examples_Calculation_Perfect_Game");
    }

    public void Examples_Calculation_Final_Frame_Spare(List<ScoreCasesString> values) {
        for (ScoreCasesString value : values) {
            ScoreCasesTyped typed = new ScoreCasesTyped(value);
            System.out.println(typed);
        }
        fail("Not implemented: Examples_Calculation_Final_Frame_Spare");
    }

    public void Examples_Calculation_Final_Frame_Strike(List<ScoreCasesString> values) {
        for (ScoreCasesString value : values) {
            ScoreCasesTyped typed = new ScoreCasesTyped(value);
            System.out.println(typed);
        }
        fail("Not implemented: Examples_Calculation_Final_Frame_Strike");
    }

    public void Examples_Calculation_Typical_Game(List<ScoreCasesString> values) {
        for (ScoreCasesString value : values) {
            ScoreCasesTyped typed = new ScoreCasesTyped(value);
            System.out.println(typed);
        }
        fail("Not implemented: Examples_Calculation_Typical_Game");
    }

}
