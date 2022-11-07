package textblock;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextBlockTest {

    private final static String DESIRED_RESULT = "{\n" +
            "    \"name\": \"John Doe\",\n" +
            "    \"age\": 45,\n" +
            "    \"address\": \"Doe Street, 23, Java Town\"\n" +
            "}";

    @Test
    public void testTextBlock() {
        String text = """
                {
                    "name": "John Doe",
                    "age": 45,
                    "address": "Doe Street, 23, Java Town"
                }
                """;

        System.out.println(text);

        assertEquals(DESIRED_RESULT, text.trim());
    }

}
