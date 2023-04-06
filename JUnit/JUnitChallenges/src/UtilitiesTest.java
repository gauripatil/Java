import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UtilitiesTest {

    Utilities utilities;

    @Before
    public void setup() {
        utilities = new Utilities();
        System.out.println("Running a test...");
    }

    @Test
    public void everyNthChar() {
        char[] output = utilities.everyNthChar(new  char[] {'h', 'e', 'l', 'l', 'o'}, 2);
        assertArrayEquals(new char[] { 'e', 'l'}, output);
        char[] output2 = utilities.everyNthChar(new  char[] {'h', 'e', 'l', 'l', 'o'}, 8);
        assertArrayEquals(new char[] {'h', 'e', 'l', 'l', 'o'}, output2);
    }

    @Test
    public void removePairs() {
        String result1 = utilities.removePairs("AABCDDEFF");
        System.out.println(result1);
        assertEquals("ABCDEF", result1);

        String result2 = utilities.removePairs("ABCCABDEEF");
        System.out.println(result2);
        assertEquals("ABCABDEF", result2);

        assertNull("Did not get null returned when argument passed was null", utilities.removePairs(null));
        assertEquals("A", utilities.removePairs("A"));
        assertEquals("", utilities.removePairs(""));
    }

    @Test
    public void converter() {
        assertEquals(300, utilities.converter(10, 5));
    }

    @Test
    public void nullIfOddLength() {
        assertNull(utilities.nullIfOddLength("odd"));
        assertNotNull(utilities.nullIfOddLength("even"));
    }
}