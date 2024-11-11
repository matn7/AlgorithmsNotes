package october_2024;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class DailyTemperatureTest {

    DailyTemperature dailyTemperature;

    @BeforeEach
    public void setup() {
        dailyTemperature = new DailyTemperature();
    }

    @Test
    public void testExample1() {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] output = dailyTemperature.dailyTemperatures(temperatures);
        assertArrayEquals(new int[] {1, 1, 4, 2, 1, 1, 0, 0}, output);
    }

    @Test
    public void testExample2() {
        int[] temperatures = {30, 40, 50, 60};
        int[] output = dailyTemperature.dailyTemperatures(temperatures);
        assertArrayEquals(new int[] {1, 1, 1, 0}, output);
    }

}
