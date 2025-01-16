package november_2024;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarFleet2Test {

    CarFleet2 carFleet2;

    @BeforeEach
    public void setup() {
        carFleet2 = new CarFleet2();
    }

    @Test
    public void testExample1() {
        int target = 12;
        int[] position = {10,8,0,5,3};
        int[] speed = {2,4,1,1,3};

        int result = carFleet2.carFleet(target, position, speed);
        assertEquals(3, result);
    }

    @Test
    public void testExample2() {
        int target = 10;
        int[] position = {6, 8};
        int[] speed = {3, 2};

        int result = carFleet2.carFleet(target, position, speed);
        assertEquals(2, result);
    }

    @Test
    public void testExample3() {
        int target = 10;
        int[] position = {8,3,7,4,6,5};
        int[] speed = {4,4,4,4,4,4};
        int result = carFleet2.carFleet(target, position, speed);
        assertEquals(6, result);
    }

}
