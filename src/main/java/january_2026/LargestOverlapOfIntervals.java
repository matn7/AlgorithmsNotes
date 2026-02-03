package january_2026;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LargestOverlapOfIntervals {

    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(5, 7));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(4, 8));

        LargestOverlapOfIntervals largestOverlapOfIntervals = new LargestOverlapOfIntervals();
        int result = largestOverlapOfIntervals.largestOverlapOfIntervals(intervals);
        System.out.println(result);

    }

    public int largestOverlapOfIntervals(ArrayList<Interval> intervals) {
        ArrayList<EventPoint> points = new ArrayList<>();

        for (Interval interval : intervals) {
            points.add(new EventPoint(interval.start, 'S'));
            points.add(new EventPoint(interval.end, 'E'));
        }

        points.sort((a, b) -> {
            if (a.time!=b.time) {
                return Integer.compare(a.time, b.time);
            }
            return Character.compare(a.type, b.type);
        });

        int activeIntervals = 0;
        int maxOverlaps = 0;

        for (EventPoint point : points) {
            if (point.type == 'S') {
                activeIntervals += 1;
            } else {
                activeIntervals -= 1;
            }
            maxOverlaps = Math.max(maxOverlaps, activeIntervals);
        }
        return maxOverlaps;
    }

    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static class EventPoint {
        int time;
        char type;

        public EventPoint(int time, char type) {
            this.time = time;
            this.type = type;
        }
    }

}
