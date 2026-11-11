package spectable;

import java.util.List;
import java.util.ArrayList;
import spectable.common.*;
import production.*;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tennis_Scoring_glue {
    private static final String DNCString = "?DNC?";

    public void Examples_DataType_TennisScore(List<ValidValuesString> values) {
        for (ValidValuesString value : values) {
            boolean error = false;
            System.out.println(value);
            ValidValuesTyped vvt = new ValidValuesTyped(value);
            try {
                new TennisScore(vvt.value);
            }
            catch(NumberFormatException e){
                error = true;
            }
            assertEquals(vvt.isValid.toBoolean(), !error, " Value " + vvt.value);
        }
    }

    public void Examples_Calculation_Equal_Scores_Below_Forty(List<ScoringCasesString> values) {
        for (ScoringCasesString value : values) {
            ScoringCasesTyped typed = new ScoringCasesTyped(value);
            System.out.println(typed);
        }
        fail("Not implemented: Examples_Calculation_Equal_Scores_Below_Forty");
    }

}
