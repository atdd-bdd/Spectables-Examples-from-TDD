package spectable.tests;

import java.util.List;
import java.util.ArrayList;
import spectable.common.*;
import spectable.Bowling_Game_glue;
import production.*;
import org.junit.jupiter.api.Test;

public class Bowling_Game_Test {

    // -------------------------
    // Calculation Tests
    // -------------------------
    @Test
    public void Calculation_Gutter_Game() {
        Bowling_Game_glue glue = new Bowling_Game_glue();
        List<ScoreCasesString> objectList1 = new ArrayList<>();
        objectList1.add(new ScoreCasesString("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0", "0"));
        glue.Examples_Calculation_Gutter_Game(objectList1);
    }

    @Test
    public void Calculation_All_Ones() {
        Bowling_Game_glue glue = new Bowling_Game_glue();
        List<ScoreCasesString> objectList2 = new ArrayList<>();
        objectList2.add(new ScoreCasesString("1,1,1,1,1,1,1,1,1,1", ""));
        glue.Examples_Calculation_All_Ones(objectList2);
    }

    @Test
    public void Calculation_Single_Spare() {
        Bowling_Game_glue glue = new Bowling_Game_glue();
        List<ScoreCasesString> objectList3 = new ArrayList<>();
        objectList3.add(new ScoreCasesString("5,5,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0", "16"));
        glue.Examples_Calculation_Single_Spare(objectList3);
    }

    @Test
    public void Calculation_Multiple_Spares() {
        Bowling_Game_glue glue = new Bowling_Game_glue();
        List<ScoreCasesString> objectList4 = new ArrayList<>();
        objectList4.add(new ScoreCasesString("5,5,5,5,5,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0", "30"));
        glue.Examples_Calculation_Multiple_Spares(objectList4);
    }

    @Test
    public void Calculation_Single_Strike() {
        Bowling_Game_glue glue = new Bowling_Game_glue();
        List<ScoreCasesString> objectList5 = new ArrayList<>();
        objectList5.add(new ScoreCasesString("10,3,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0", "24"));
        glue.Examples_Calculation_Single_Strike(objectList5);
    }

    @Test
    public void Calculation_Consecutive_Strikes() {
        Bowling_Game_glue glue = new Bowling_Game_glue();
        List<ScoreCasesString> objectList6 = new ArrayList<>();
        objectList6.add(new ScoreCasesString("10,10,3,4,0,0,0,0,0,0,0,0,0,0,0,0,0", "47"));
        glue.Examples_Calculation_Consecutive_Strikes(objectList6);
    }

    @Test
    public void Calculation_Perfect_Game() {
        Bowling_Game_glue glue = new Bowling_Game_glue();
        List<ScoreCasesString> objectList7 = new ArrayList<>();
        objectList7.add(new ScoreCasesString("10,10,10,10,10,10,10,10,10,10,10,10", "300"));
        glue.Examples_Calculation_Perfect_Game(objectList7);
    }

    @Test
    public void Calculation_Final_Frame_Spare() {
        Bowling_Game_glue glue = new Bowling_Game_glue();
        List<ScoreCasesString> objectList8 = new ArrayList<>();
        objectList8.add(new ScoreCasesString("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,5,7", "17"));
        glue.Examples_Calculation_Final_Frame_Spare(objectList8);
    }

    @Test
    public void Calculation_Final_Frame_Strike() {
        Bowling_Game_glue glue = new Bowling_Game_glue();
        List<ScoreCasesString> objectList9 = new ArrayList<>();
        objectList9.add(new ScoreCasesString("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,10,7,2", "19"));
        glue.Examples_Calculation_Final_Frame_Strike(objectList9);
    }

    @Test
    public void Calculation_Typical_Game() {
        Bowling_Game_glue glue = new Bowling_Game_glue();
        List<ScoreCasesString> objectList10 = new ArrayList<>();
        objectList10.add(new ScoreCasesString("1,4,4,5,6,4,5,5,10,0,1,7,3,6,4,10,2,8,6", "133"));
        glue.Examples_Calculation_Typical_Game(objectList10);
    }

    // -------------------------
    // DataType Tests
    // -------------------------
    @Test
    public void DataType_BowlingScore() {
        Bowling_Game_glue glue = new Bowling_Game_glue();
        List<ValidValuesString> objectList11 = new ArrayList<>();
        objectList11.add(new ValidValuesString("0", "True", ""));
        objectList11.add(new ValidValuesString("57", "True", ""));
        objectList11.add(new ValidValuesString("133", "True", ""));
        objectList11.add(new ValidValuesString("300", "True", ""));
        objectList11.add(new ValidValuesString("-1", "False", "Score cannot be negative."));
        objectList11.add(new ValidValuesString("301", "False", "Maximum score is 300."));
        glue.Examples_DataType_BowlingScore(objectList11);
    }

}
