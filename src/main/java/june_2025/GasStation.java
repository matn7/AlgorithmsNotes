package june_2025;

public class GasStation {

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};

        GasStation gasStation = new GasStation();
        int result = gasStation.canCompleteCircuit(gas, cost);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumGas = 0;
        int sumCost = 0;
        for (int i = 0; i < gas.length; i++) {
            sumGas += gas[i];
            sumCost += cost[i];
        }
        if (sumCost > sumGas) {
            return -1;
        }
        int total = 0;
        int res = 0;

        for (int i = 0; i < gas.length; i++) {
            total += (gas[i] - cost[i]);
            if (total < 0) {
                total = 0;
                res = i + 1;
            }
        }

        return res;
    }

}
