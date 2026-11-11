package spectable.tests;

import java.util.List;
import java.util.ArrayList;
import spectable.common.*;
import spectable.Common_Mark_glue;
import org.junit.jupiter.api.Test;

public class Common_Mark_Test {

    // -------------------------
    // Scenario Tests
    // -------------------------
    @Test
    public void Scenario_Render_Shopping_List_Document() {
        Common_Mark_glue glue = new Common_Mark_glue();

        glue.Given_Markdown("""
        # Shopping List

        - Milk
        - Bread
        """);

        glue.When_Markdown_Is_Rendered();

        glue.Then_Html_Is("""
        <h1>Shopping List</h1>
        <ul>
        <li>Milk</li>
        <li>Bread</li>
        </ul>
        """);

    }

    @Test
    public void Scenario_Render_Complex_Document() {
        Common_Mark_glue glue = new Common_Mark_glue();

        glue.Given_Markdown("""
        # CommonMark

        Welcome to **CommonMark**.

        > Important note

        - Item 1
        - *Item 2*

        Use `code`.
        """);

        glue.When_Markdown_Is_Rendered();

        glue.Then_Html_Is("""
        <h1>CommonMark</h1>
        <p>Welcome to <strong>CommonMark</strong>.</p>
        <blockquote>
        <p>Important note</p>
        </blockquote>
        <ul>
        <li>Item 1</li>
        <li><em>Item 2</em></li>
        </ul>
        <p>Use <code>code</code>.</p>
        """);

    }

    // -------------------------
    // Calculation Tests
    // -------------------------
    @Test
    public void Calculation_Render_Plain_Paragraph() {
        Common_Mark_glue glue = new Common_Mark_glue();
        List<MarkdownRenderingString> objectList1 = new ArrayList<>();
        objectList1.add(new MarkdownRenderingString("Hello world", "<p>Hello world</p>", "Single-line paragraph."));
        objectList1.add(new MarkdownRenderingString("CommonMark", "<p>CommonMark</p>", "Simple text."));
        glue.Examples_Calculation_Render_Plain_Paragraph(objectList1);
    }

    @Test
    public void Calculation_Render_ATX_Headings() {
        Common_Mark_glue glue = new Common_Mark_glue();
        List<MarkdownRenderingString> objectList2 = new ArrayList<>();
        objectList2.add(new MarkdownRenderingString("# Heading", "<h1>Heading</h1>", "Level 1 heading."));
        objectList2.add(new MarkdownRenderingString("## Heading", "<h2>Heading</h2>", "Level 2 heading."));
        objectList2.add(new MarkdownRenderingString("### Heading", "<h3>Heading</h3>", "Level 3 heading."));
        glue.Examples_Calculation_Render_ATX_Headings(objectList2);
    }

    @Test
    public void Calculation_Render_Emphasis() {
        Common_Mark_glue glue = new Common_Mark_glue();
        List<MarkdownRenderingString> objectList3 = new ArrayList<>();
        objectList3.add(new MarkdownRenderingString("*text*", "<p><em>text</em></p>", "Emphasis."));
        objectList3.add(new MarkdownRenderingString("**text**", "<p><strong>text</strong></p>", "Strong emphasis."));
        objectList3.add(new MarkdownRenderingString("***text***", "<p><em><strong>text</strong></em></p>", "Nested emphasis."));
        glue.Examples_Calculation_Render_Emphasis(objectList3);
    }

    @Test
    public void Calculation_Render_Links() {
        Common_Mark_glue glue = new Common_Mark_glue();
        List<MarkdownRenderingString> objectList4 = new ArrayList<>();
        objectList4.add(new MarkdownRenderingString("[Home](/)", "<p><a href=\"/\">Home</a></p>", "Relative URL."));
        objectList4.add(new MarkdownRenderingString("[Google](https://google.com)", "<p><a href=\"https://google.com\">Google</a></p>", "Absolute URL."));
        glue.Examples_Calculation_Render_Links(objectList4);
    }

    @Test
    public void Calculation_Render_Unordered_Lists() {
        Common_Mark_glue glue = new Common_Mark_glue();
        List<MarkdownRenderingString> objectList5 = new ArrayList<>();
        objectList5.add(new MarkdownRenderingString("- A", "<ul><li>A</li></ul>", "Single item."));
        objectList5.add(new MarkdownRenderingString("- A\\n- B", "<ul><li>A</li><li>B</li></ul>", "Two items."));
        glue.Examples_Calculation_Render_Unordered_Lists(objectList5);
    }

    @Test
    public void Calculation_Render_Ordered_Lists() {
        Common_Mark_glue glue = new Common_Mark_glue();
        List<MarkdownRenderingString> objectList6 = new ArrayList<>();
        objectList6.add(new MarkdownRenderingString("1. A", "<ol><li>A</li></ol>", "Single item."));
        objectList6.add(new MarkdownRenderingString("1. A\\n2. B", "<ol><li>A</li><li>B</li></ol>", "Two items."));
        glue.Examples_Calculation_Render_Ordered_Lists(objectList6);
    }

    @Test
    public void Calculation_Render_Inline_Code() {
        Common_Mark_glue glue = new Common_Mark_glue();
        List<MarkdownRenderingString> objectList7 = new ArrayList<>();
        objectList7.add(new MarkdownRenderingString("`code`", "<p><code>code</code></p>", "Inline code."));
        glue.Examples_Calculation_Render_Inline_Code(objectList7);
    }

    @Test
    public void Calculation_Render_Block_Quote() {
        Common_Mark_glue glue = new Common_Mark_glue();
        List<MarkdownRenderingString> objectList8 = new ArrayList<>();
        objectList8.add(new MarkdownRenderingString("> quoted", "<blockquote><p>quoted</p></blockquote>", "Simple block quote."));
        glue.Examples_Calculation_Render_Block_Quote(objectList8);
    }

    @Test
    public void Calculation_Render_Escaped_Characters() {
        Common_Mark_glue glue = new Common_Mark_glue();
        List<MarkdownRenderingString> objectList9 = new ArrayList<>();
        objectList9.add(new MarkdownRenderingString("\\*text\\*", "<p>*text*</p>", "Asterisks are literal."));
        glue.Examples_Calculation_Render_Escaped_Characters(objectList9);
    }

    @Test
    public void Calculation_Render_Horizontal_Rule() {
        Common_Mark_glue glue = new Common_Mark_glue();
        List<MarkdownRenderingString> objectList10 = new ArrayList<>();
        objectList10.add(new MarkdownRenderingString("---", "<hr />", "Horizontal rule."));
        glue.Examples_Calculation_Render_Horizontal_Rule(objectList10);
    }

}
