package january_2026;

import java.util.ArrayList;
import java.util.List;

public class EmployeeFreeTime {

    // O(nlog(n)) time | O(n) space
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> flattenList = new ArrayList<>();
        for (List<Interval> intervals : schedule) {
            flattenList.addAll(intervals);
        }
        if (flattenList.isEmpty()) {
            return new ArrayList<>();
        }
        flattenList.sort((a, b)-> a.start - b.start);
        List<Interval> overlap = new ArrayList<>();
        List<Interval> result = new ArrayList<>();
        overlap.add(flattenList.get(0));
        for (int i = 1; i < flattenList.size(); i++) {
            Interval currentInterval = overlap.get(overlap.size() - 1);
            Interval newInterval = flattenList.get(i);
            if (currentInterval.end >= newInterval.start) {
                currentInterval.start = Math.min(currentInterval.start, newInterval.start);
                currentInterval.end = Math.max(currentInterval.end, newInterval.end);
            } else {
                result.add(new Interval(currentInterval.end, newInterval.start));
                overlap.add(newInterval);
            }
        }

        return result;
    }

    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}
