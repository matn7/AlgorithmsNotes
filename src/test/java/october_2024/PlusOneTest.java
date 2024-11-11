package october_2024;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlusOneTest {

    PlusOne plusOne;

    @BeforeEach
    public void setup() {
        plusOne = new PlusOne();
    }

    @Test
    public void plusOneBaseTest() {
        int[] digits = {1, 2, 3};
        int[] result = plusOne.plusOne(digits);
        assertArrayEquals(new int[] {1, 2, 4}, result);
    }

    @Test
    public void plusOneOverflowTest() {
        int[] digits = {9, 9, 9};
        int[] result = plusOne.plusOne(digits);
        assertArrayEquals(new int[] {1, 0, 0, 0}, result);
    }

    @Test
    public void plusOneSingleDigitTest() {
        int[] digits = {8};
        int[] result = plusOne.plusOne(digits);
        assertArrayEquals(new int[] {9}, result);
    }

    @Test
    public void plusOneSingleDigitV2Test() {
        int[] digits = {9};
        int[] result = plusOne.plusOne(digits);
        assertArrayEquals(new int[] {1, 0}, result);
    }

}
