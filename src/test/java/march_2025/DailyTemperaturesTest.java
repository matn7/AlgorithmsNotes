package march_2025;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DailyTemperaturesTest {

    DailyTemperatures dailyTemperatures;

    @BeforeEach
    public void setUp() {
        dailyTemperatures = new DailyTemperatures();
    }

    @Test
    public void test1() {
        int[] nums = {73,74,75,71,69,72,76,73};
        int[] expected = {1,1,4,2,1,1,0,0};

        int[] result = dailyTemperatures.dailyTemperatures(nums);
        assertArrayEquals(expected, result);
    }


}