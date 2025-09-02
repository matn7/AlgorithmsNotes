package august_2025;

import java.util.Arrays;
import java.util.PriorityQueue;

public class CarPooling {

    // O(nlog(n)) time | O(nlog(n)) space
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a, b) -> a[1] - b[1]);

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]); // [end, numPassengers]
        int currPass = 0;

        for (int[] t : trips) {
            int numPass = t[0];
            int start = t[1];
            int end = t[2];

            while (!minHeap.isEmpty() && minHeap.peek()[0] <= start) {
                currPass -= minHeap.peek()[1];
                minHeap.poll();
            }

            currPass += numPass;
            if (currPass > capacity) {
                return false;
            }
            minHeap.add(new int[] {end, numPass});
        }
        return true;
    }

}
