package april_2025;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MeetingRooms {

    public static void main(String[] args) {
        // Input: intervals = [(0,30),(5,10),(15,20)]
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(0, 30));
        intervals.add(new Interval(5, 10));
        intervals.add(new Interval(15, 20));

        MeetingRooms meetingRooms = new MeetingRooms();
        boolean result = meetingRooms.canAttendMeetings(intervals);
        System.out.println(result);
    }

    // O(nlog(n)) time | O(n) space
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals.size() <= 1) {
            return true;
        }
        intervals.sort(Comparator.comparingInt(a -> a.start));

        int end = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            Interval currentMeeting = intervals.get(i); // [5, 10]
            if (currentMeeting.start < end) { // 30
                return false;
            }
            end = currentMeeting.end;
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
