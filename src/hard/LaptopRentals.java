package hard;

import java.util.*;

public class LaptopRentals {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> times = new ArrayList<>();
        times.add(new ArrayList<>(Arrays.asList(0, 2)));
        times.add(new ArrayList<>(Arrays.asList(1, 4)));
        times.add(new ArrayList<>(Arrays.asList(4, 6)));
        times.add(new ArrayList<>(Arrays.asList(0, 4)));
        times.add(new ArrayList<>(Arrays.asList(7, 8)));
        times.add(new ArrayList<>(Arrays.asList(9, 11)));
        times.add(new ArrayList<>(Arrays.asList(3, 10)));

        LaptopRentals laptopRentalsREPEAT = new LaptopRentals();
        laptopRentalsREPEAT.laptopRentals(times);
    }

    // O(nlog(n)) time | O(n) space
    public int laptopRentalsArrays(ArrayList<ArrayList<Integer>> times) {
        if (times.isEmpty()) {
            return 0;
        }

        int usedLaptops = 0;
        ArrayList<Integer> startTimes = new ArrayList<>();
        ArrayList<Integer> endTimes = new ArrayList<>();
        for (ArrayList<Integer> element : times) {
            startTimes.add(element.get(0));
            endTimes.add(element.get(1));
        }

        Collections.sort(startTimes);
        Collections.sort(endTimes);

        int startIterator = 0;
        int endIterator = 0;

        while (startIterator < times.size()) {
            if (startTimes.get(startIterator) >= endTimes.get(endIterator)) {
                usedLaptops--;
                endIterator++;
            }

            usedLaptops++;
            startIterator++;
        }

        return usedLaptops;
    }

    // O(nlog(n)) time | O(n) space
    public int laptopRentals(ArrayList<ArrayList<Integer>> times) {
        // Write your code here.
        if (times.isEmpty()) {
            return 0;
        }
        times.sort(Comparator.comparingInt(a -> a.get(0)));
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.add(times.get(0).get(1));
        for (int idx = 1; idx < times.size(); idx++) {
            ArrayList<Integer> currentInterval = times.get(idx);
            if (heap.peek() <= currentInterval.get(0)) {
                heap.poll();
            }
            heap.add(currentInterval.get(1));
        }
        return heap.size();
    }
}
