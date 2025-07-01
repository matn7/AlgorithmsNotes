package june_2025;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CanAttendMeetings {

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
//        intervals.add(new Interval(0, 30));
//        intervals.add(new Interval(5, 10));
//        intervals.add(new Interval(15, 20));

        intervals.add(new Interval(5, 8));
        intervals.add(new Interval(9, 15));

        CanAttendMeetings canAttendMeetings = new CanAttendMeetings();
        boolean result = canAttendMeetings.canAttendMeetings(intervals);
        System.out.println(result);
    }

    // O(nlog(n)) time | O(n) space
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals.isEmpty()) {
            return true;
        }
        intervals.sort(Comparator.comparingInt(a -> a.start));
        Interval currMeeting = intervals.get(0);

        for (int i = 1; i < intervals.size(); i++) {
            Interval nextMeeting = intervals.get(i);
            if (nextMeeting.start >= currMeeting.end) {
                currMeeting = nextMeeting;
            } else {
                return false;
            }
        }
        return true;
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
