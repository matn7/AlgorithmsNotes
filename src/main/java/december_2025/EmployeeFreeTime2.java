package december_2025;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeFreeTime2 {

    // O(nlog(n)) time | O(n) space
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> result = new ArrayList<>();
        if (schedule.isEmpty()) {
            return result;
        }
        List<Interval> allIntervals = new ArrayList<>();
        for (List<Interval> interval : schedule) {
            allIntervals.addAll(interval);
        }

        allIntervals.sort((a, b) -> a.start - b.start);
        Interval prev = allIntervals.get(0);
        for (int i = 1; i < allIntervals.size(); i++) {
            Interval curr = allIntervals.get(i);

            if (curr.start <= prev.end) {
                prev.end = Math.max(prev.end, curr.end);
            } else {
                result.add(new Interval(prev.end, curr.start));
                prev = curr;
            }
        }

        return result;
    }

    static class Interval {
        public int start;
        public int end;

        public Interval() {}

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    };

}
