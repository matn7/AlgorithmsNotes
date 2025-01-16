package november_2024;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Koko2Test {

    Koko2 koko2;

    @BeforeEach
    public void setup() {
        this.koko2 = new Koko2();
    }

    @Test
    public void testExample1() {
        // piles = [3,6,7,11], h = 8
        int[] piles = {3, 6, 7, 11};
        int h = 8;

        assertEquals(4, koko2.minEatingSpeed(piles, h));
    }

    @Test
    public void testExample2() {
        // piles = [30,11,23,4,20], h = 5
        int[] piles = {30, 11, 23, 4, 20};
        int h = 5;

        assertEquals(30, koko2.minEatingSpeed(piles, h));
    }

    @Test
    public void testExample3() {
        // piles = [30,11,23,4,20], h = 6
        int[] piles = {30, 11, 23, 4, 20};
        int h = 6;

        assertEquals(23, koko2.minEatingSpeed(piles, h));
    }

}
