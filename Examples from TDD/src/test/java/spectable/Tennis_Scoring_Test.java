package spectable.tests;

import java.util.List;
import java.util.ArrayList;
import spectable.common.*;
import spectable.Tennis_Scoring_glue;
import production.*;
import org.junit.jupiter.api.Test;

public class Tennis_Scoring_Test {

    // -------------------------
    // Calculation Tests
    // -------------------------
    @Test
    public void Calculation_Equal_Scores_Below_Forty() {
        Tennis_Scoring_glue glue = new Tennis_Scoring_glue();
        List<ScoringCasesString> objectList1 = new ArrayList<>();
        objectList1.add(new ScoringCasesString("0", "0", "Love-All"));
        objectList1.add(new ScoringCasesString("1", "1", "Fifteen-All"));
        objectList1.add(new ScoringCasesString("2", "2", "Thirty-All"));
        glue.Examples_Calculation_Equal_Scores_Below_Forty(objectList1);
    }

    @Test
    public void Calculation_Ordinary_Scores() {
        Tennis_Scoring_glue glue = new Tennis_Scoring_glue();
        List<ScoringCasesString> objectList2 = new ArrayList<>();
        objectList2.add(new ScoringCasesString("1", "0", "Fifteen-Love"));
        objectList2.add(new ScoringCasesString("2", "0", "Thirty-Love"));
        objectList2.add(new ScoringCasesString("3", "0", "Forty-Love"));
        objectList2.add(new ScoringCasesString("2", "1", "Thirty-Fifteen"));
        objectList2.add(new ScoringCasesString("3", "1", "Forty-Fifteen"));
        objectList2.add(new ScoringCasesString("3", "", ""));
        glue.Examples_Calculation_Ordinary_Scores(objectList2);
    }

    // -------------------------
    // DataType Tests
    // -------------------------
    @Test
    public void DataType_TennisScore() {
        Tennis_Scoring_glue glue = new Tennis_Scoring_glue();
        List<ValidValuesString> objectList3 = new ArrayList<>();
        objectList3.add(new ValidValuesString("Love-All", "True", ""));
        objectList3.add(new ValidValuesString("Fifteen-Love", "True", ""));
        objectList3.add(new ValidValuesString("Thirty-Fifteen", "True", ""));
        objectList3.add(new ValidValuesString("Forty-Thirty", "True", ""));
        objectList3.add(new ValidValuesString("Deuce", "True", ""));
        objectList3.add(new ValidValuesString("Advantage Player 1", "True", ""));
        objectList3.add(new ValidValuesString("Advantage Player 2", "True", ""));
        objectList3.add(new ValidValuesString("Win For Player 1", "True", ""));
        objectList3.add(new ValidValuesString("Win For Player 2", "True", ""));
        objectList3.add(new ValidValuesString("Fifty-Love", "False", "Fifty is not a tennis score."));
        objectList3.add(new ValidValuesString("Advantage", "False", "Advantage must identify the player."));
        objectList3.add(new ValidValuesString("Winner Player 1", "False", "Win For is the correct format."));
        objectList3.add(new ValidValuesString("", "False", "Tennis score must not be empty."));
        glue.Examples_DataType_TennisScore(objectList3);
    }

}
