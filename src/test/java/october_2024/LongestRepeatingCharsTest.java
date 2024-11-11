package october_2024;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestRepeatingCharsTest {

    LongestRepeatingChars longestRepeatingChars;

    @BeforeEach
    public void setup() {
        longestRepeatingChars = new LongestRepeatingChars();
    }

    @Test
    public void testExample1() {
        String s = "ABAB";
        int k = 2;
        int actual = longestRepeatingChars.characterReplacement(s, k);
        assertEquals(4, actual);
    }

    @Test
    public void testExample2() {
        String s = "AABABBA";
        int k = 1;
        int actual = longestRepeatingChars.characterReplacement(s, k);
        assertEquals(4, actual);
    }

    @Test
    public void testExample3() {
        String s = "AAAA";
        int k = 2;
        int actual = longestRepeatingChars.characterReplacement(s, k);
        assertEquals(4, actual);
    }

}
