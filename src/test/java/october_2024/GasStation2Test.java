package october_2024;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GasStation2Test {

    GasStation2 gasStation;

    @BeforeEach
    public void setup() {
        gasStation = new GasStation2();
    }

    @Test
    public void canCompleteTest() {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        assertEquals(3, gasStation.canCompleteCircuit(gas, cost));
    }

    @Test
    public void canNotCompleteTest() {
        int[] gas = {1, 2, 3, 4, 1};
        int[] cost = {3, 4, 5, 1, 2};
        assertEquals(-1, gasStation.canCompleteCircuit(gas, cost));
    }



}
