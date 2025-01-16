package november_2024;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PermutationInStringTest {

    PermutationInString permutation;

    @BeforeEach
    public void setup() {
        permutation = new PermutationInString();
    }

    @Test
    public void testExample1() {
        String s1 = "ab";
        String s2 = "eidbaooo";
        assertTrue(permutation.checkInclusion(s1, s2));
    }

    @Test
    public void testExample2() {
        String s1 = "ab";
        String s2 = "eidboaoo";
        assertFalse(permutation.checkInclusion(s1, s2));
    }

    @Test
    public void testExample3() {
        String s1 = "ab";
        String s2 = "eidbaoooab";
        assertTrue(permutation.checkInclusion(s1, s2));
    }

}
