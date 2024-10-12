package october_2024;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeatManagerTest {

    SeatManager seatManager;

    @BeforeEach
    public void setup() {
        seatManager = new SeatManager(5);
    }

    @Test
    public void reserveTest() {
        int firstSeat = seatManager.reserve();
        Assertions.assertEquals(1, firstSeat);
        int secondSeat = seatManager.reserve();
        Assertions.assertEquals(2, secondSeat);
    }

    @Test
    public void unreserveTest() {

    }


}