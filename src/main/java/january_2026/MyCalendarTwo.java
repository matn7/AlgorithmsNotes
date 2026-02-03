package january_2026;

import java.util.TreeMap;

public class MyCalendarTwo {

    // O(n) time | O(n) space
    private TreeMap<Integer, Integer> timeline;

    public MyCalendarTwo() {
        timeline = new TreeMap<>();
    }

    public boolean book(int startTime, int endTime) {
        timeline.put(startTime, timeline.getOrDefault(startTime, 0) + 1);
        timeline.put(endTime, timeline.getOrDefault(endTime, 0) - 1);

        int active = 0;
        for (int delta : timeline.values()) {
            active += delta;
            if (active > 2) {
                timeline.put(startTime, timeline.get(startTime) - 1);
                if (timeline.get(startTime) == 0) {
                    timeline.remove(startTime);
                }

                timeline.put(endTime, timeline.get(endTime) + 1);
                if (timeline.get(endTime) == 0) {
                    timeline.remove(endTime);
                }
                return false;
            }
        }
        return true;
    }

}
