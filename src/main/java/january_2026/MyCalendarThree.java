package january_2026;

import java.util.TreeMap;

public class MyCalendarThree {

    TreeMap<Integer, Integer> timeline;

    public MyCalendarThree() {
        timeline = new TreeMap<>();
    }

    public int book(int startTime, int endTime) {
        timeline.put(startTime, timeline.getOrDefault(startTime, 0) + 1);
        timeline.put(endTime, timeline.getOrDefault(endTime, 0) - 1);

        int active = 0;
        int maxK = 0;
        for (int time : timeline.values()) {
            active += time;
            maxK = Math.max(maxK, active);
        }
        return maxK;
    }

}
