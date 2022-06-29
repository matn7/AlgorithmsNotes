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
    // #2: 22/06/2022
    public int laptopRentals(ArrayList<ArrayList<Integer>> times) {
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
