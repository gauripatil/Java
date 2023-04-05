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
//        fail("This test is yet to implement..");
    }

    @Test
    public void removePairs() {
        String input1 = "AABCDDEFF";
        String result1 = utilities.removePairs(input1);
        System.out.println(result1);
        String expectedResult1 = "ABCDEF";
        assertEquals(result1, expectedResult1);

        String input2 = "ABCCABDEEF";
        String result2 = utilities.removePairs(input2);
        System.out.println(result2);
        String expectedResult2 = "ABCABDEF";
        assertEquals(result2, expectedResult2);



    }

    @Test
    public void converter() {
    }

    @Test
    public void nullIfOddLength() {
    }
}