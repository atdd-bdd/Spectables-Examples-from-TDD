package spectable.tests;

import java.util.List;
import java.util.ArrayList;
import spectable.common.*;
import spectable.Mars_Rover_glue;
import production.*;
import org.junit.jupiter.api.Test;

public class Mars_Rover_Test {

    // -------------------------
    // Calculation Tests
    // -------------------------
    @Test
    public void Calculation_Navigate_Rover() {
        Mars_Rover_glue glue = new Mars_Rover_glue();
        List<NavigationCasesString> objectList1 = new ArrayList<>();
        objectList1.add(new NavigationCasesString("0,0,N", "", "0,0,N", "No commands."));
        objectList1.add(new NavigationCasesString("0,0,N", "M", "0,1,N", "Move north."));
        objectList1.add(new NavigationCasesString("0,0,E", "M", "1,0,E", "Move east."));
        objectList1.add(new NavigationCasesString("0,0,S", "M", "0,-1,S", "Move south."));
        objectList1.add(new NavigationCasesString("0,0,W", "M", "-1,0,W", "Move west."));
        objectList1.add(new NavigationCasesString("0,0,N", "L", "0,0,W", "Turn left from north."));
        objectList1.add(new NavigationCasesString("0,0,N", "R", "0,0,E", "Turn right from north."));
        objectList1.add(new NavigationCasesString("0,0,N", "RM", "1,0,E", "Turn then move."));
        glue.Examples_Calculation_Navigate_Rover(objectList1);
    }

    // -------------------------
    // DataType Tests
    // -------------------------
    @Test
    public void DataType_Heading() {
        Mars_Rover_glue glue = new Mars_Rover_glue();
        List<ValidValuesString> objectList2 = new ArrayList<>();
        objectList2.add(new ValidValuesString("N", "True", ""));
        objectList2.add(new ValidValuesString("E", "True", ""));
        objectList2.add(new ValidValuesString("S", "True", ""));
        objectList2.add(new ValidValuesString("W", "True", ""));
        objectList2.add(new ValidValuesString("NE", "False", "Only cardinal directions allowed."));
        objectList2.add(new ValidValuesString("X", "False", "Unknown heading."));
        objectList2.add(new ValidValuesString("", "False", "Heading is required."));
        glue.Examples_DataType_Heading(objectList2);
    }

    @Test
    public void DataType_Commands() {
        Mars_Rover_glue glue = new Mars_Rover_glue();
        List<ValidValuesString> objectList3 = new ArrayList<>();
        objectList3.add(new ValidValuesString("L", "True", "Turn left."));
        objectList3.add(new ValidValuesString("R", "True", "Turn right."));
        objectList3.add(new ValidValuesString("M", "True", "Move forward."));
        objectList3.add(new ValidValuesString("LRM", "True", "Sequence of valid commands."));
        objectList3.add(new ValidValuesString("MX", "False", "X is not a valid command."));
        objectList3.add(new ValidValuesString("123", "False", "Commands must be alphabetic."));
        glue.Examples_DataType_Commands(objectList3);
    }

    @Test
    public void DataType_Position() {
        Mars_Rover_glue glue = new Mars_Rover_glue();
        List<ValidValuesString> objectList4 = new ArrayList<>();
        objectList4.add(new ValidValuesString("0,0,N", "True", ""));
        objectList4.add(new ValidValuesString("1,2,E", "True", ""));
        objectList4.add(new ValidValuesString("9,9,S", "True", ""));
        objectList4.add(new ValidValuesString("0,0", "False", "Heading is missing."));
        objectList4.add(new ValidValuesString("N,0,0", "False", "Coordinates must be first."));
        objectList4.add(new ValidValuesString("A,B,N", "False", "Coordinates must be numeric."));
        glue.Examples_DataType_Position(objectList4);
    }

}
