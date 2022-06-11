package hard;

import java.util.*;

public class LaptopRentalsREPEAT {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> times = new ArrayList<>();
        times.add(new ArrayList<>(Arrays.asList(0, 2)));
        times.add(new ArrayList<>(Arrays.asList(1, 4)));
        times.add(new ArrayList<>(Arrays.asList(4, 6)));
        times.add(new ArrayList<>(Arrays.asList(0, 4)));
        times.add(new ArrayList<>(Arrays.asList(7, 8)));
        times.add(new ArrayList<>(Arrays.asList(9, 11)));
        times.add(new ArrayList<>(Arrays.asList(3, 10)));

        LaptopRentalsREPEAT laptopRentalsREPEAT = new LaptopRentalsREPEAT();
        laptopRentalsREPEAT.laptopRentals(times);
    }

    // O(nlog(n)) time | O(n) space
    // OK - repeated 01/02/2022
//    public int laptopRentals(ArrayList<ArrayList<Integer>> times) {
//        if (times.isEmpty()) {
//            return 0;
//        }
//        // times = [[0, 2], [1, 4], [4, 6], [0, 4], [7, 8], [9, 11], [3, 10]]
//
//        int usedLaptops = 0;
//        ArrayList<Integer> startTimes = new ArrayList<>();
//        ArrayList<Integer> endTimes = new ArrayList<>();
//        for (ArrayList<Integer> element : times) {
//            startTimes.add(element.get(0));
//            endTimes.add(element.get(1));
//        }
//
//        Collections.sort(startTimes);
//        Collections.sort(endTimes);
//
//        //                                   s
//        // startTime = [0, 0, 1, 3, 4, 7, 9]
//        // endTime =   [2, 4, 4, 6, 7, 10, 11]
//        //                          e
//        int startIterator = 0;
//        int endIterator = 0;
//
//        while (startIterator < times.size()) {
//            if (startTimes.get(startIterator) >= endTimes.get(endIterator)) { // 9 >= 6
//                usedLaptops--;
//                endIterator++;
//            }
//
//            usedLaptops++; // 3
//            startIterator++; // 3
//        }
//
//        return usedLaptops; // 3
//    }


    public int laptopRentals(ArrayList<ArrayList<Integer>> times) {
        // O(nlog(n)) time | O(n) space
        // Write your code here.
        // times = [[0, 2], [1, 4], [4, 6], [0, 4], [7, 8], [9, 11], [3, 10]]
        if (times.isEmpty()) {
            return 0;
        }
        times.sort(Comparator.comparingInt(a -> a.get(0)));
        // times = [[0, 2], [0, 4], [1, 4], [3, 10], [4, 6], [7, 8], [9, 11]]
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        // heap of end time elements
        //          8       <-- shortest time element to stop rental
        //         / \
        //        10  11
        //
        heap.add(times.get(0).get(1));
        for (int idx = 1; idx < times.size(); idx++) {
            ArrayList<Integer> currentInterval = times.get(idx); // [9, 11]
            if (heap.peek() <= currentInterval.get(0)) { // 6 <= 11
                heap.poll();
            }
            heap.add(currentInterval.get(1));
        }
        return heap.size();
    }

}
