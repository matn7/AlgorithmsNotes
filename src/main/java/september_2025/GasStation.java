package september_2025;

public class GasStation {

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
            total += gas[i] - cost[i];
            if (total < 0) {
                res = i + 1;
                total = 0;
            }
        }
        return res;
    }

}
