package november_2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LaptopRentals {

    public static void main(String[] args) {
        int[][] times = {{0,2}, {1,4}, {4,6}, {0,4}, {7,8}, {9,11}, {3,10}};

        int result = laptopRentals(times);
    }

    // O(nlog(n)) time | O(n) space
    public static int laptopRentals(int[][] times) {
        Arrays.sort(times, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> endTimesQueue = new PriorityQueue<>();

//        // [[0,2], [1,4], [0,4], [4,6], [7,8]]
        for (int[] time : times) {
            if (endTimesQueue.isEmpty()) {
                endTimesQueue.add(time[1]);
            } else {
                Integer queueEndTime = endTimesQueue.peek();
                int currentStartTime = time[0];
                if (queueEndTime > currentStartTime) { // 2 > 4
                    endTimesQueue.add(time[1]);
                } else {
                    endTimesQueue.poll();
                    endTimesQueue.add(time[1]);
                }
            }
        }

//        for (int[] time : times) {
//            if (endTimesQueue.isEmpty()) {
//                endTimesQueue.add(time[1]);
//            } else {
//                Integer previousEnd = endTimesQueue.peek(); // 6
//                Integer currentStart = time[0]; // 9
//                if (currentStart < previousEnd) {
//                    endTimesQueue.add(time[1]);
//                } else {
//                    endTimesQueue.poll();
//                    endTimesQueue.add(time[1]);
//                }
//            }
//        }

        return endTimesQueue.size();
    }

}
