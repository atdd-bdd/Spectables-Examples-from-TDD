package spectable;

import java.util.List;
import java.util.ArrayList;
import spectable.common.*;
import production.*;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommonMark_glue {
    private static final String DNCString = "?DNC?";

    public void Examples_DataType_Markdown(List<ValidValuesString> values) {
        for (ValidValuesString value : values) {
            boolean error = false;
            System.out.println(value);
            ValidValuesTyped vvt = new ValidValuesTyped(value);
            try {
                new Markdown(vvt.value);
            }
            catch(NumberFormatException e){
                error = true;
            }
            assertEquals(vvt.isValid.toBoolean(), !error, " Value " + vvt.value);
        }
    }

    public void Examples_DataType_Html(List<ValidValuesString> values) {
        for (ValidValuesString value : values) {
            boolean error = false;
            System.out.println(value);
            ValidValuesTyped vvt = new ValidValuesTyped(value);
            try {
                new Html(vvt.value);
            }
            catch(NumberFormatException e){
                error = true;
            }
            assertEquals(vvt.isValid.toBoolean(), !error, " Value " + vvt.value);
        }
    }

    public void Examples_Calculation_Render_Paragraph(List<RenderingCasesString> values) {
        for (RenderingCasesString value : values) {
            RenderingCasesTyped typed = new RenderingCasesTyped(value);
            System.out.println(typed);
        }
        fail("Not implemented: Examples_Calculation_Render_Paragraph");
    }

    public void Examples_Calculation_Preserve_Spaces_Within_Paragraph(List<RenderingCasesString> values) {
        for (RenderingCasesString value : values) {
            RenderingCasesTyped typed = new RenderingCasesTyped(value);
            System.out.println(typed);
        }
        fail("Not implemented: Examples_Calculation_Preserve_Spaces_Within_Paragraph");
    }

    public void Examples_Calculation_ATX_Headings(List<RenderingCasesString> values) {
        for (RenderingCasesString value : values) {
            RenderingCasesTyped typed = new RenderingCasesTyped(value);
            System.out.println(typed);
        }
        fail("Not implemented: Examples_Calculation_ATX_Headings");
    }

    public void Examples_Calculation_Heading_Text_Is_Parsed(List<RenderingCasesString> values) {
        for (RenderingCasesString value : values) {
            RenderingCasesTyped typed = new RenderingCasesTyped(value);
            System.out.println(typed);
        }
        fail("Not implemented: Examples_Calculation_Heading_Text_Is_Parsed");
    }

    public void Examples_Calculation_Italic_Emphasis(List<RenderingCasesString> values) {
        for (RenderingCasesString value : values) {
            RenderingCasesTyped typed = new RenderingCasesTyped(value);
            System.out.println(typed);
        }
        fail("Not implemented: Examples_Calculation_Italic_Emphasis");
    }

    public void Examples_Calculation_Strong_Emphasis(List<RenderingCasesString> values) {
        for (RenderingCasesString value : values) {
            RenderingCasesTyped typed = new RenderingCasesTyped(value);
            System.out.println(typed);
        }
        fail("Not implemented: Examples_Calculation_Strong_Emphasis");
    }

    public void Examples_Calculation_Nested_Emphasis(List<RenderingCasesString> values) {
        for (RenderingCasesString value : values) {
            RenderingCasesTyped typed = new RenderingCasesTyped(value);
            System.out.println(typed);
        }
        fail("Not implemented: Examples_Calculation_Nested_Emphasis");
    }

    public void Examples_Calculation_Inline_Link(List<RenderingCasesString> values) {
        for (RenderingCasesString value : values) {
            RenderingCasesTyped typed = new RenderingCasesTyped(value);
            System.out.println(typed);
        }
        fail("Not implemented: Examples_Calculation_Inline_Link");
    }

    public void Examples_Calculation_Link_Inside_Text(List<RenderingCasesString> values) {
        for (RenderingCasesString value : values) {
            RenderingCasesTyped typed = new RenderingCasesTyped(value);
            System.out.println(typed);
        }
        fail("Not implemented: Examples_Calculation_Link_Inside_Text");
    }

    public void Examples_Calculation_Unordered_List(List<RenderingCasesString> values) {
        for (RenderingCasesString value : values) {
            RenderingCasesTyped typed = new RenderingCasesTyped(value);
            System.out.println(typed);
        }
        fail("Not implemented: Examples_Calculation_Unordered_List");
    }

    public void Examples_Calculation_Ordered_List(List<RenderingCasesString> values) {
        for (RenderingCasesString value : values) {
            RenderingCasesTyped typed = new RenderingCasesTyped(value);
            System.out.println(typed);
        }
        fail("Not implemented: Examples_Calculation_Ordered_List");
    }

    public void Examples_Calculation_Inline_Code(List<RenderingCasesString> values) {
        for (RenderingCasesString value : values) {
            RenderingCasesTyped typed = new RenderingCasesTyped(value);
            System.out.println(typed);
        }
        fail("Not implemented: Examples_Calculation_Inline_Code");
    }

    public void Examples_Calculation_Fenced_Code_Block(List<RenderingCasesString> values) {
        for (RenderingCasesString value : values) {
            RenderingCasesTyped typed = new RenderingCasesTyped(value);
            System.out.println(typed);
        }
        fail("Not implemented: Examples_Calculation_Fenced_Code_Block");
    }

    public void Examples_Calculation_Block_Quote(List<RenderingCasesString> values) {
        for (RenderingCasesString value : values) {
            RenderingCasesTyped typed = new RenderingCasesTyped(value);
            System.out.println(typed);
        }
        fail("Not implemented: Examples_Calculation_Block_Quote");
    }

    public void Examples_Calculation_Horizontal_Rule(List<RenderingCasesString> values) {
        for (RenderingCasesString value : values) {
            RenderingCasesTyped typed = new RenderingCasesTyped(value);
            System.out.println(typed);
        }
        fail("Not implemented: Examples_Calculation_Horizontal_Rule");
    }

    public void Examples_Calculation_Paragraph_With_Link_And_Emphasis(List<RenderingCasesString> values) {
        for (RenderingCasesString value : values) {
            RenderingCasesTyped typed = new RenderingCasesTyped(value);
            System.out.println(typed);
        }
        fail("Not implemented: Examples_Calculation_Paragraph_With_Link_And_Emphasis");
    }

}
