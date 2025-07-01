package june_2025;

public class GasStation2 {

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};

        GasStation2 gasStation2 = new GasStation2();
        int result = gasStation2.canCompleteCircuit(gas, cost);
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
        if (sumGas < sumCost) {
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
