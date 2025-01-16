package december_2024;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MeetingRooms {

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(0, 30));
        intervals.add(new Interval(5, 10));
        intervals.add(new Interval(15, 20));

        MeetingRooms meetingRooms = new MeetingRooms();
        boolean result = meetingRooms.canAttendMeetings(intervals);
        System.out.println(result);
    }

    public boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort(Comparator.comparing(i -> i.start));

        int end = intervals.get(0).end;

        for (Interval interval : intervals) {
            if (interval.start < end) {
                return false;
            } else {
                end = interval.end;
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
