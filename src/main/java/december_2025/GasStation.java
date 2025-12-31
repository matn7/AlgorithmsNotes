package december_2025;

public class GasStation {

    // O(n) time | O(1) space
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = 0;
        int costSum = 0;
        for (int i = 0; i < gas.length; i++) {
            gasSum += gas[i];
            costSum += cost[i];
        }

        if (costSum > gasSum) {
            return -1;
        }

        int start = 0;
        int sum = 0;
        for (int i = 0; i < gas.length; i++) {
            sum = sum + (gas[i] - cost[i]);
            if (sum < 0) {
                start = i + 1;
                sum = 0;
            }
        }
        return start;
    }

}
