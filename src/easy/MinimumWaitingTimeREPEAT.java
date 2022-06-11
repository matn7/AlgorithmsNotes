package easy;

import java.util.Arrays;

public class MinimumWaitingTimeREPEAT {

    public static void main(String[] args) {
        int[] queries = {3, 2, 1, 2, 6};
        MinimumWaitingTimeREPEAT minimumWaitingTimeREPEAT = new MinimumWaitingTimeREPEAT();
        int result = minimumWaitingTimeREPEAT.minimumWaitingTime(queries);
        System.out.println(result);
    }

    // OK - repeated 01/03/2022
    // O(nlog(n)) time | O(1) space
    // rec([3,2,1,2,6])
    public int minimumWaitingTime(int[] queries) {
        // Write your code here.

        // 1. Sort input array
        Arrays.sort(queries);
        // queries = [1,2,2,3,6]
        int totalWaitingTime = 0;

        //              i
        // [1, 2, 2, 3, 6]
        //     1  1  1  1
        //        2  2  2
        //           2  2
        //              3
        for (int idx = 0; idx < queries.length; idx++) {
            int duration = queries[idx]; // 6
            int queriesLeft = queries.length - (idx + 1); // 5 - (3+1) = 0
            totalWaitingTime += duration * queriesLeft; // 14 + 3 = 17
        }
        return totalWaitingTime; // 17
    }

}
