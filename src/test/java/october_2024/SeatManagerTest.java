package october_2024;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SeatManagerTest {

    SeatManager seatManager;

    @BeforeEach
    public void setup() {
        seatManager = new SeatManager(5);
    }

    @Test
    public void reserveTest() {
        assertEquals(1, seatManager.reserve());
        assertEquals(2, seatManager.reserve());
        seatManager.unreserve(1);
        assertEquals(1, seatManager.reserve());
        assertEquals(3, seatManager.reserve());
        assertEquals(4, seatManager.reserve());
        assertEquals(5, seatManager.reserve());
    }



}