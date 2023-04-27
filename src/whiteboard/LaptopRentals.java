package whiteboard;

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

        LaptopRentals laptopRentals = new LaptopRentals();
        laptopRentals.laptopRentals(times);
    }

    // O(nlog(n)) time | O(n) space
    public int laptopRentals(ArrayList<ArrayList<Integer>> times) {
        if (times.size() == 0) {
            return 0;
        }

        int usedLaptops = 0;
        List<Integer> startTimes = new ArrayList<>();
        List<Integer> endTimes = new ArrayList<>();

        for (int i = 0; i < times.size(); i++) {
            ArrayList<Integer> time = times.get(i);
            startTimes.add(time.get(0));
            endTimes.add(time.get(1));
        }

        Collections.sort(startTimes);
        Collections.sort(endTimes);

        int startIterator = 0;int endIterator = 0;
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
    public int laptopRentals2(ArrayList<ArrayList<Integer>> times) {
        // Write your code here.
        PriorityQueue<Laptop> borrowedLaptops = new PriorityQueue<>();

        Collections.sort(times, Comparator.comparingInt(a -> a.get(0)));

        for (int idx = 0; idx < times.size(); idx++) {
            ArrayList<Integer> current = times.get(idx);
            if (borrowedLaptops.isEmpty()) {
                borrowedLaptops.add(new Laptop(current.get(0), current.get(1)));
            } else {
                Laptop currentlyUsed = borrowedLaptops.peek();
                if (currentlyUsed.endTime <= current.get(0)) {
                    borrowedLaptops.poll();
                }
                borrowedLaptops.add(new Laptop(current.get(0), current.get(1)));
            }
        }

        return borrowedLaptops.size();
    }

    static class Laptop implements Comparable<Laptop> {
        int startTime;
        int endTime;

        public Laptop(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Laptop o) {
            return this.endTime - o.endTime;
        }
    }

}
