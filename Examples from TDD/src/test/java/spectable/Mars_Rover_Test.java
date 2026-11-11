package spectable.tests;

import java.util.List;
import java.util.ArrayList;
import spectable.common.*;
import spectable.Mars_Rover_glue;
import production.*;
import org.junit.jupiter.api.Test;

public class Mars_Rover_Test {

    // -------------------------
    // DataType Tests
    // -------------------------
    @Test
    public void DataType_Heading() {
        Mars_Rover_glue glue = new Mars_Rover_glue();
        List<ValidValuesString> objectList1 = new ArrayList<>();
        objectList1.add(new ValidValuesString("N", "True", ""));
        objectList1.add(new ValidValuesString("E", "True", ""));
        objectList1.add(new ValidValuesString("S", "True", ""));
        objectList1.add(new ValidValuesString("W", "True", ""));
        objectList1.add(new ValidValuesString("NE", "False", "Only cardinal directions allowed."));
        objectList1.add(new ValidValuesString("X", "False", "Unknown heading."));
        objectList1.add(new ValidValuesString("", "False", "Heading is required."));
        glue.Examples_DataType_Heading(objectList1);
    }

    @Test
    public void DataType_Commands() {
        Mars_Rover_glue glue = new Mars_Rover_glue();
        List<ValidValuesString> objectList2 = new ArrayList<>();
        objectList2.add(new ValidValuesString("L", "True", "Turn left."));
        objectList2.add(new ValidValuesString("R", "True", "Turn right."));
        objectList2.add(new ValidValuesString("M", "True", "Move forward."));
        objectList2.add(new ValidValuesString("LRM", "True", "Sequence of valid commands."));
        objectList2.add(new ValidValuesString("MX", "False", "X is not a valid command."));
        objectList2.add(new ValidValuesString("123", "False", "Commands must be alphabetic."));
        glue.Examples_DataType_Commands(objectList2);
    }

    @Test
    public void DataType_Position() {
        Mars_Rover_glue glue = new Mars_Rover_glue();
        List<ValidValuesString> objectList3 = new ArrayList<>();
        objectList3.add(new ValidValuesString("0,0,N", "True", ""));
        objectList3.add(new ValidValuesString("1,2,E", "True", ""));
        objectList3.add(new ValidValuesString("9,9,S", "True", ""));
        objectList3.add(new ValidValuesString("0,0", "False", "Heading is missing."));
        objectList3.add(new ValidValuesString("N,0,0", "False", "Coordinates must be first."));
        objectList3.add(new ValidValuesString("A,B,N", "False", "Coordinates must be numeric."));
        glue.Examples_DataType_Position(objectList3);
    }

}
