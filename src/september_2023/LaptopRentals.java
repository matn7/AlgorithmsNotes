package september_2023;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LaptopRentals {

    public static void main(String[] args) {
        int[][] timesArr = {
                {0, 2},
                {1, 4},
                {4, 6},
                {0, 4},
                {7, 8},
                {9, 11},
                {3, 10}
        };
        ArrayList<ArrayList<Integer>> times = new ArrayList<>();
        for (int[] time : timesArr) {
            ArrayList<Integer> entry = new ArrayList<>();
            entry.add(time[0]);
            entry.add(time[1]);
            times.add(entry);
        }

        LaptopRentals laptopRentals = new LaptopRentals();
        laptopRentals.laptopRentals(times);
    }

    // O(nlog(n)) time | O(n) space
    public int laptopRentals(ArrayList<ArrayList<Integer>> times) {
        // Write your code here.
        // [[0,2], [1,4], [4,6], [0,4], [7,8], [9,11], [3,10]]
        // sort
        // [[0,2], [0,4], [1,4], [3,10], [4,6], [7,8], [9,11]]
        //                                               *
        times.sort(Comparator.comparingInt(a -> a.get(0)));
        PriorityQueue<Integer> queue = new PriorityQueue<>(); // [8, 10, 11]
        for (ArrayList<Integer> time : times) {
            if (queue.isEmpty()) {
                queue.add(time.get(1));
            } else {
                Integer previousEnd = queue.peek(); // 6
                Integer currentStart = time.get(0); // 9
                if (currentStart < previousEnd) {
                    queue.add(time.get(1));
                } else {
                    queue.poll();
                    queue.add(time.get(1));
                }
            }
        }

        return queue.size();
    }

}
