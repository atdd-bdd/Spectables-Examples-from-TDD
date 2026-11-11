package spectable;

import java.util.List;
import java.util.ArrayList;
import spectable.common.*;
import static org.junit.jupiter.api.Assertions.fail;

public class Common_Mark_glue {
    private static final String DNCString = "?DNC?";

    public void Given_Markdown(String value) {
        System.out.println(value);
        fail("Not implemented: Given_Markdown");
    }

    public void When_Markdown_Is_Rendered() {
        fail("Not implemented: When_Markdown_Is_Rendered");
    }

    public void Then_Html_Is(String value) {
        System.out.println(value);
        fail("Not implemented: Then_Html_Is");
    }


    public void Examples_Calculation_Render_Plain_Paragraph(List<MarkdownRenderingString> values) {
        for (MarkdownRenderingString value : values) {
            MarkdownRenderingTyped typed = new MarkdownRenderingTyped(value);
            System.out.println(typed);
        }
        fail("Not implemented: Examples_Calculation_Render_Plain_Paragraph");
    }

    public void Examples_Calculation_Render_ATX_Headings(List<MarkdownRenderingString> values) {
        for (MarkdownRenderingString value : values) {
            MarkdownRenderingTyped typed = new MarkdownRenderingTyped(value);
            System.out.println(typed);
        }
        fail("Not implemented: Examples_Calculation_Render_ATX_Headings");
    }

    public void Examples_Calculation_Render_Emphasis(List<MarkdownRenderingString> values) {
        for (MarkdownRenderingString value : values) {
            MarkdownRenderingTyped typed = new MarkdownRenderingTyped(value);
            System.out.println(typed);
        }
        fail("Not implemented: Examples_Calculation_Render_Emphasis");
    }

    public void Examples_Calculation_Render_Links(List<MarkdownRenderingString> values) {
        for (MarkdownRenderingString value : values) {
            MarkdownRenderingTyped typed = new MarkdownRenderingTyped(value);
            System.out.println(typed);
        }
        fail("Not implemented: Examples_Calculation_Render_Links");
    }

    public void Examples_Calculation_Render_Unordered_Lists(List<MarkdownRenderingString> values) {
        for (MarkdownRenderingString value : values) {
            MarkdownRenderingTyped typed = new MarkdownRenderingTyped(value);
            System.out.println(typed);
        }
        fail("Not implemented: Examples_Calculation_Render_Unordered_Lists");
    }

    public void Examples_Calculation_Render_Ordered_Lists(List<MarkdownRenderingString> values) {
        for (MarkdownRenderingString value : values) {
            MarkdownRenderingTyped typed = new MarkdownRenderingTyped(value);
            System.out.println(typed);
        }
        fail("Not implemented: Examples_Calculation_Render_Ordered_Lists");
    }

    public void Examples_Calculation_Render_Inline_Code(List<MarkdownRenderingString> values) {
        for (MarkdownRenderingString value : values) {
            MarkdownRenderingTyped typed = new MarkdownRenderingTyped(value);
            System.out.println(typed);
        }
        fail("Not implemented: Examples_Calculation_Render_Inline_Code");
    }

    public void Examples_Calculation_Render_Block_Quote(List<MarkdownRenderingString> values) {
        for (MarkdownRenderingString value : values) {
            MarkdownRenderingTyped typed = new MarkdownRenderingTyped(value);
            System.out.println(typed);
        }
        fail("Not implemented: Examples_Calculation_Render_Block_Quote");
    }

    public void Examples_Calculation_Render_Escaped_Characters(List<MarkdownRenderingString> values) {
        for (MarkdownRenderingString value : values) {
            MarkdownRenderingTyped typed = new MarkdownRenderingTyped(value);
            System.out.println(typed);
        }
        fail("Not implemented: Examples_Calculation_Render_Escaped_Characters");
    }

    public void Examples_Calculation_Render_Horizontal_Rule(List<MarkdownRenderingString> values) {
        for (MarkdownRenderingString value : values) {
            MarkdownRenderingTyped typed = new MarkdownRenderingTyped(value);
            System.out.println(typed);
        }
        fail("Not implemented: Examples_Calculation_Render_Horizontal_Rule");
    }

}
