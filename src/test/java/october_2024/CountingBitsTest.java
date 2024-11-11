package october_2024;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class CountingBitsTest {

    CountingBits countingBits;

    @BeforeEach
    public void setup() {
        countingBits = new CountingBits();
    }

    @Test
    public void example1Test() {
        assertArrayEquals(new int[] {0, 1, 1}, countingBits.countBits(2));
    }

    @Test
    public void example2Test() {
        assertArrayEquals(new int[] {0, 1, 1, 2, 1, 2}, countingBits.countBits(5));
    }

}
