package december_2025;

import java.util.TreeMap;

public class MyCalendarThree {

    public static void main(String[] args) {
        MyCalendarThree myCalendarThree = new MyCalendarThree();
        myCalendarThree.book(10, 20);
        myCalendarThree.book(50, 60);
        myCalendarThree.book(10, 40);
        System.out.println(myCalendarThree.book(5, 15));
    }


    TreeMap<Integer, Integer> timelines;

    public MyCalendarThree() {
        timelines = new TreeMap<>();
    }

    public int book(int startTime, int endTime) {
        timelines.put(startTime, timelines.getOrDefault(startTime, 0) + 1);
        timelines.put(endTime, timelines.getOrDefault(endTime, 0) - 1);

        int active = 0;
        int maxK = 0;

        for (int delta : timelines.values()) {
            active += delta;
            maxK = Math.max(maxK, active);
        }
        return maxK;
    }

}

