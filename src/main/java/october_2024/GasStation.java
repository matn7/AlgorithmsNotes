package october_2024;

public class GasStation {

    public static void main(String[] args) {
        GasStation gasStation = new GasStation();
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};

        int result = gasStation.canCompleteCircuit(gas, cost);
        System.out.println(result);
    }

    public int canCompleteCircuit2(int[] gas, int[] cost) {
        return 0;
    }

    // O(n^2) time | O(1) space
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int stations = cost.length;
        for (int i = 0; i < gas.length; i++) {
            int tank = 0;
            int visited = 0;
            int j = i;
            while (visited < stations) {
                j = j % stations;
                // tank gas at current station
                tank += gas[j];
                // start route
                tank = tank - cost[j];
                // I wasn't able to reach destination
                if (tank < 0) {
                    // cannot even reach to other gas station
                    break;
                }
                // I was able to reach destination
                visited++;
                j++;
            }
            if (visited == stations) {
                return i;
            }
        }

        return -1;
    }

}
