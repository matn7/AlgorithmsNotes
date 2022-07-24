package easy;

import java.util.Arrays;

public class MinimumWaitingTime {

    public static void main(String[] args) {
        int[] queries = {3, 2, 1, 2, 6};
        MinimumWaitingTime minimumWaitingTimeREPEAT = new MinimumWaitingTime();
        int result = minimumWaitingTimeREPEAT.minimumWaitingTime(queries);
        System.out.println(result);
    }

    // O(nlog(n)) time | O(1) space
    public int minimumWaitingTime(int[] queries) {
        // Write your code here.
        Arrays.sort(queries);
        int totalWaitingTime = 0;

        for (int idx = 0; idx < queries.length; idx++) {
            int duration = queries[idx];
            int queriesLeft = queries.length - (idx + 1);
            totalWaitingTime += duration * queriesLeft;
        }
        return totalWaitingTime;
    }

}
