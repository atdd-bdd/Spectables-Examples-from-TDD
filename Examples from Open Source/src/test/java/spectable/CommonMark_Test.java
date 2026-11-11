package spectable.tests;

import java.util.List;
import java.util.ArrayList;
import spectable.common.*;
import spectable.CommonMark_glue;
import production.*;
import org.junit.jupiter.api.Test;

public class CommonMark_Test {

    // -------------------------
    // Calculation Tests
    // -------------------------
    @Test
    public void Calculation_Render_Paragraph() {
        CommonMark_glue glue = new CommonMark_glue();
        List<RenderingCasesString> objectList1 = new ArrayList<>();
        objectList1.add(new RenderingCasesString("Hello world", "<p>Hello world</p>", "Single line paragraph."));
        objectList1.add(new RenderingCasesString("CommonMark", "<p>CommonMark</p>", "Simple text."));
        glue.Examples_Calculation_Render_Paragraph(objectList1);
    }

    @Test
    public void Calculation_Preserve_Spaces_Within_Paragraph() {
        CommonMark_glue glue = new CommonMark_glue();
        List<RenderingCasesString> objectList2 = new ArrayList<>();
        objectList2.add(new RenderingCasesString("Hello world", "<p>Hello world</p>", "Single space retained."));
        glue.Examples_Calculation_Preserve_Spaces_Within_Paragraph(objectList2);
    }

    @Test
    public void Calculation_ATX_Headings() {
        CommonMark_glue glue = new CommonMark_glue();
        List<RenderingCasesString> objectList3 = new ArrayList<>();
        objectList3.add(new RenderingCasesString("# Heading", "<h1>Heading</h1>", "Level 1 heading."));
        objectList3.add(new RenderingCasesString("## Heading", "<h2>Heading</h2>", "Level 2 heading."));
        objectList3.add(new RenderingCasesString("### Heading", "<h3>Heading</h3>", "Level 3 heading."));
        glue.Examples_Calculation_ATX_Headings(objectList3);
    }

    @Test
    public void Calculation_Heading_Text_Is_Parsed() {
        CommonMark_glue glue = new CommonMark_glue();
        List<RenderingCasesString> objectList4 = new ArrayList<>();
        objectList4.add(new RenderingCasesString("# *Heading*", "<h1><em>Heading</em></h1>", "Emphasis in heading."));
        glue.Examples_Calculation_Heading_Text_Is_Parsed(objectList4);
    }

    @Test
    public void Calculation_Italic_Emphasis() {
        CommonMark_glue glue = new CommonMark_glue();
        List<RenderingCasesString> objectList5 = new ArrayList<>();
        objectList5.add(new RenderingCasesString("*text*", "<p><em>text</em></p>", "Basic emphasis."));
        glue.Examples_Calculation_Italic_Emphasis(objectList5);
    }

    @Test
    public void Calculation_Strong_Emphasis() {
        CommonMark_glue glue = new CommonMark_glue();
        List<RenderingCasesString> objectList6 = new ArrayList<>();
        objectList6.add(new RenderingCasesString("**text**", "<p><strong>text</strong></p>", "Strong emphasis."));
        glue.Examples_Calculation_Strong_Emphasis(objectList6);
    }

    @Test
    public void Calculation_Nested_Emphasis() {
        CommonMark_glue glue = new CommonMark_glue();
        List<RenderingCasesString> objectList7 = new ArrayList<>();
        objectList7.add(new RenderingCasesString("***text***", "<p><em><strong>text</strong></em></p>", "Nested markup."));
        glue.Examples_Calculation_Nested_Emphasis(objectList7);
    }

    @Test
    public void Calculation_Inline_Link() {
        CommonMark_glue glue = new CommonMark_glue();
        List<RenderingCasesString> objectList8 = new ArrayList<>();
        objectList8.add(new RenderingCasesString("[CommonMark](https://a.com)", "<p><a href=\"https://a.com\">CommonMark</a></p>", "Basic link."));
        glue.Examples_Calculation_Inline_Link(objectList8);
    }

    @Test
    public void Calculation_Link_Inside_Text() {
        CommonMark_glue glue = new CommonMark_glue();
        List<RenderingCasesString> objectList9 = new ArrayList<>();
        objectList9.add(new RenderingCasesString("Visit [site](https://a.com) today", "<p>Visit <a href=\"https://a.com\">site</a> today</p>", "Embedded link."));
        glue.Examples_Calculation_Link_Inside_Text(objectList9);
    }

    @Test
    public void Calculation_Unordered_List() {
        CommonMark_glue glue = new CommonMark_glue();
        List<RenderingCasesString> objectList10 = new ArrayList<>();
        objectList10.add(new RenderingCasesString("- A\\n- B", "<ul><li>A</li><li>B</li></ul>", "Two-item list."));
        glue.Examples_Calculation_Unordered_List(objectList10);
    }

    @Test
    public void Calculation_Ordered_List() {
        CommonMark_glue glue = new CommonMark_glue();
        List<RenderingCasesString> objectList11 = new ArrayList<>();
        objectList11.add(new RenderingCasesString("1. A\\n2. B", "<ol><li>A</li><li>B</li></ol>", "Ordered list."));
        glue.Examples_Calculation_Ordered_List(objectList11);
    }

    @Test
    public void Calculation_Inline_Code() {
        CommonMark_glue glue = new CommonMark_glue();
        List<RenderingCasesString> objectList12 = new ArrayList<>();
        objectList12.add(new RenderingCasesString("`code`", "<p><code>code</code></p>", "Inline code."));
        glue.Examples_Calculation_Inline_Code(objectList12);
    }

    @Test
    public void Calculation_Fenced_Code_Block() {
        CommonMark_glue glue = new CommonMark_glue();
        List<RenderingCasesString> objectList13 = new ArrayList<>();
        objectList13.add(new RenderingCasesString("```\\nabc\\n```", "<pre><code>abc\\n</code></pre>", "Fenced code block."));
        glue.Examples_Calculation_Fenced_Code_Block(objectList13);
    }

    @Test
    public void Calculation_Block_Quote() {
        CommonMark_glue glue = new CommonMark_glue();
        List<RenderingCasesString> objectList14 = new ArrayList<>();
        objectList14.add(new RenderingCasesString("> quoted", "<blockquote><p>quoted</p></blockquote>", "Simple quote."));
        glue.Examples_Calculation_Block_Quote(objectList14);
    }

    @Test
    public void Calculation_Horizontal_Rule() {
        CommonMark_glue glue = new CommonMark_glue();
        List<RenderingCasesString> objectList15 = new ArrayList<>();
        objectList15.add(new RenderingCasesString("---", "<hr />", "Horizontal rule."));
        glue.Examples_Calculation_Horizontal_Rule(objectList15);
    }

    @Test
    public void Calculation_Paragraph_With_Link_And_Emphasis() {
        CommonMark_glue glue = new CommonMark_glue();
        List<RenderingCasesString> objectList16 = new ArrayList<>();
        objectList16.add(new RenderingCasesString("Visit *our* https://a.com", "<p>Visit <em>our</em> https://a.comsite</a></p>", "Combined features."));
        glue.Examples_Calculation_Paragraph_With_Link_And_Emphasis(objectList16);
    }

    // -------------------------
    // DataType Tests
    // -------------------------
    @Test
    public void DataType_Markdown() {
        CommonMark_glue glue = new CommonMark_glue();
        List<ValidValuesString> objectList17 = new ArrayList<>();
        objectList17.add(new ValidValuesString("Hello", "True", ""));
        objectList17.add(new ValidValuesString("# Heading", "True", ""));
        objectList17.add(new ValidValuesString("**Bold**", "True", ""));
        glue.Examples_DataType_Markdown(objectList17);
    }

    @Test
    public void DataType_Html() {
        CommonMark_glue glue = new CommonMark_glue();
        List<ValidValuesString> objectList18 = new ArrayList<>();
        objectList18.add(new ValidValuesString("<p>Hello</p>", "True", ""));
        objectList18.add(new ValidValuesString("<h1>Heading</h1>", "True", ""));
        glue.Examples_DataType_Html(objectList18);
    }

}
