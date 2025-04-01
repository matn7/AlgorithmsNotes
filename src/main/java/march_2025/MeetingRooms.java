package march_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MeetingRooms {

    public static void main(String[] args) {
//        int[][] intervals = {{0, 30}, {15, 20}, {5, 10}};
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(0, 30));
        intervals.add(new Interval(15, 20));
        intervals.add(new Interval(5, 10));
        MeetingRooms meetingRooms = new MeetingRooms();
        boolean result = meetingRooms.canAttendMeetings(intervals);
        System.out.println(result);

    }

    public boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort((a, b) -> a.start - b.start);

        for (int i = 1; i < intervals.size(); i++) {
            int prevEnd = intervals.get(i - 1).end;
            int curStart = intervals.get(i).start;
            if (curStart < prevEnd) {
                return false;
            }
        }

        return true;
    }

    static class Interval {
        public int start, end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}
