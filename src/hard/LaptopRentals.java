package hard;

import java.util.*;

public class LaptopRentals {

    public static void main(String[] args) {
        ArrayList<Integer> one = new ArrayList<>();
        one.add(0);
        one.add(2);
        ArrayList<Integer> two = new ArrayList<>();
        two.add(1);
        two.add(4);
        ArrayList<Integer> three = new ArrayList<>();
        three.add(4);
        three.add(6);
        ArrayList<Integer> four = new ArrayList<>();
        four.add(0);
        four.add(4);
        ArrayList<Integer> five = new ArrayList<>();
        five.add(7);
        five.add(8);
        ArrayList<Integer> six = new ArrayList<>();
        six.add(9);
        six.add(11);
        ArrayList<Integer> seven = new ArrayList<>();
        seven.add(3);
        seven.add(10);
        ArrayList<ArrayList<Integer>> times = new ArrayList<>(Arrays.asList(one, two, three, four, five,
                six, seven));

        LaptopRentals laptopRentals = new LaptopRentals();
        laptopRentals.laptopRentals2(times);
    }

    // O(nlog(n)) time | O(n) space
    public int laptopRentals(ArrayList<ArrayList<Integer>> times) {
        // Write your code here.
        if (times.size() == 0) {
            return 0;
        }
        // 0 <= start < end

        // Sort input, use heap
        times.sort(Comparator.comparingInt(a -> a.get(0)));

        // [    [0,2]    [0,4]]
        // compare 2 with 0
        int laptops = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(times.get(0).get(1)); // {[0,2]}   // PQ sorted based on endIndex 2 in example
        for (int i = 1; i < times.size(); i++) {
            // check whether laptop is not needed anymore
            if (times.get(i).get(0) < queue.peek()) {  // [0,4] < [0,2]
                // cant use laptop, overlap
                queue.add(times.get(i).get(1)); // O(log(n))
            } else {
                queue.poll();
                queue.add(times.get(i).get(1));
            }
        }

        laptops = queue.size();

        return laptops;
    }

    // O(nlog(n)) time | O(n) space
    public int laptopRentals2(ArrayList<ArrayList<Integer>> times) {
        // Write your code here.
        if (times.size() == 0) {
            return 0;
        }

        // create list of start times and list of end times
        ArrayList<Integer> start = new ArrayList<>();
        ArrayList<Integer> end = new ArrayList<>();

        for (ArrayList<Integer> element : times) {
            start.add(element.get(0));
            end.add(element.get(1));
        }

        Collections.sort(start);
        Collections.sort(end);

        int startIterator = 0;
        int endIterator = 0;

        int laptops = 0;
        while (startIterator < start.size()) {
            if (start.get(startIterator) >= end.get(endIterator)) {
                laptops -= 1;
                endIterator += 1;
            }

            laptops += 1;
            startIterator += 1;
        }

        return laptops;
    }
}























