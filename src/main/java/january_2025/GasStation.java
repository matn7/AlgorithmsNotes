package january_2025;

import java.util.Arrays;

public class GasStation {

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};

        GasStation gasStation = new GasStation();
        int result = gasStation.canCompleteCircuit(gas, cost);
        System.out.println(result);
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (Arrays.stream(gas).sum() < Arrays.stream(cost).sum()) {
            return -1;
        }

        int res = 0;
        int total = 0;

        for (int i = 0; i < gas.length; i++) {
            total += (cost[i] + gas[i]);
            if (total < 0) {
                total = 0;
                res = res + 1;
            }
        }
        return res;
    }

}
