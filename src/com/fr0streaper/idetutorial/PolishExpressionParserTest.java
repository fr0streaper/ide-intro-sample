package com.fr0streaper.idetutorial;

import org.junit.Test;
import static org.junit.Assert.*;

public class PolishExpressionParserTest {

    public static final Double EPS = 1e-6;
    public static final PolishExpressionParser parser = new PolishExpressionParser();

    @Test
    public void basicParseTest() {
        assertEquals(new Double(4), parser.parse("2 2 +").evaluate());
    }

    @Test
    public void complexParseTest() {
        assertEquals(new Double(4), parser.parse("2 3 * 4 * 5 - 1 + 2 3 + /").evaluate());
    }

    @Test
    public void basicUnaryParseTest() {
        assertEquals(new Double(-4), parser.parse("2 2 + neg").evaluate());
    }

    @Test
    public void complexUnaryParseTest() {
        assertEquals(new Double(4), parser.parse("2 neg 3 neg * 4 * 5 neg neg - 1 + 2 3 + /").evaluate());
    }

    @Test
    public void reallyComplexReleaseTest() {
        assertEquals(new Double(-12), parser.parse("2 neg 5 * 3 / 4 neg neg * 4 3 neg / -").evaluate());
    }

    @Test
    public void basicAdvancedOperationsTest() {
        assertEquals(new Double(2), parser.parse("2 exp sqr ln sqrt").evaluate());
    }

    @Test
    public void complexAdvancedOperationsTest() {
        assertTrue(Math.abs(1.0 - parser.parse("3 2 6 / ^ 9 log 6 *").evaluate()) < EPS);
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