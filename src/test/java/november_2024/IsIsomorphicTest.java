package november_2024;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IsIsomorphicTest {

    IsIsomorphic isIsomorphic;

    @BeforeEach
    public void setup() {
        isIsomorphic = new IsIsomorphic();
    }

    @Test
    public void testExample1() {
        String s = "egg";
        String t = "add";

        assertTrue(isIsomorphic.isIsomorphic(s, t));
    }

    @Test
    public void testExample2() {
        String s = "foo";
        String t = "bar";

        assertFalse(isIsomorphic.isIsomorphic(s, t));
    }

    @Test
    public void testExample3() {
        String s = "paper";
        String t = "title";

        assertTrue(isIsomorphic.isIsomorphic(s, t));
    }

}
