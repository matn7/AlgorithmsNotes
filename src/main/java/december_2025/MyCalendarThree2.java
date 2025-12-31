package december_2025;

import java.util.TreeMap;

public class MyCalendarThree2 {

    TreeMap<Integer, Integer> timeline;

    public MyCalendarThree2() {
        timeline = new TreeMap<>();
    }

    public int book(int startTime, int endTime) {
        timeline.put(startTime, timeline.getOrDefault(startTime, 0) + 1);
        timeline.put(endTime, timeline.getOrDefault(endTime, 0) - 1);

        int active = 0;
        int maxK = 0;

        for (int delta : timeline.values()) {
            active += delta;
            maxK = Math.max(maxK, active);
        }
        return maxK;
    }

}
