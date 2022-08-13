package whiteboard;

import java.util.Arrays;

public class MinimumWaitingTime {

    public static void main(String[] args) {
        int[] queries = {3, 2, 1, 2, 6};

        MinimumWaitingTime minimumWaitingTime = new MinimumWaitingTime();
        minimumWaitingTime.minimumWaitingTimeNotOptimal(queries);
    }

    // O(nlog(n)) time | O(1) space
    // rand: 07/08/2022
    public int minimumWaitingTime(int[] queries) {
        Arrays.sort(queries);
        int totalTime = 0;

        for (int i = 0; i < queries.length; i++) {
            int duration = queries[i];
            int queriesLeft = queries.length - (i + 1);
            totalTime += duration * queriesLeft;
        }
        return totalTime;
    }

    // O(n^2) time | O(1) space
    public int minimumWaitingTimeNotOptimal(int[] queries) {
        // Write your code here.
        Arrays.sort(queries);
        int waiting = 0;
        for (int i = 1; i < queries.length; i++) {
            for (int j = i; j > 0; j--) {
                waiting += queries[j - 1];
            }
        }
        return waiting;
    }
}

