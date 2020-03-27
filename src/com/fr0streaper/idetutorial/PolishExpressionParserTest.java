package com.fr0streaper.idetutorial;

import org.junit.Test;
import static org.junit.Assert.*;

public class PolishExpressionParserTest {

    public static final PolishExpressionParser parser = new PolishExpressionParser();

    @Test
    public void basicParseTest() {
        assertEquals(new Double(4), parser.parse("2 2 +").evaluate());
    }

    @Test
    public void complexParseTest() {
        assertEquals(new Double(4), parser.parse("2 3 * 4 * 5 - 1 + 2 3 + /").evaluate());
    }

    @Test(expected = IllegalArgumentException.class)
    public void basicInvalidArgumentParseTest() {
        parser.parse(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidExpressionParseTest() {
        parser.parse("2 + 2");
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidNumberParseTest() {
        parser.parse("a 1 +");
    }
}