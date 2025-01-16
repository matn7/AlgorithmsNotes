package december_2024;

public class GasStation {

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};

        GasStation gasStation = new GasStation();
        int result = gasStation.canCompleteCircuit(gas, cost);
        System.out.println(result);
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = 0;
        int costSum = 0;
        for (int i = 0; i < gas.length; i++) {
            gasSum += gas[i];
            costSum += cost[i];
        }
        if (gasSum < costSum) {
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
