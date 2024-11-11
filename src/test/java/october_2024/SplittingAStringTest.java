package october_2024;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SplittingAStringTest {

    SplittingAString splittingAString;

    @BeforeEach
    public void setup() {
        this.splittingAString = new SplittingAString();
    }

    @Test
    public void splitStringTest() {
        assertTrue(splittingAString.splitString("090089"));
        assertTrue(splittingAString.splitString("4321"));
        assertFalse(splittingAString.splitString("1234"));
    }

}
