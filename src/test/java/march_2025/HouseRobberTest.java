package march_2025;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HouseRobberTest {

    HouseRobber houseRobber;

    @BeforeEach
    public void setup() {
        houseRobber = new HouseRobber();
    }

    @Test
    public void test1() {
        int[] nums = {2, 9, 8, 3, 6};
        int result = houseRobber.rob(nums);
        Assertions.assertEquals(16, result);
    }


}