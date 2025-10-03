package september_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
        if (intervals.isEmpty()) {
            return true;
        }
        intervals.sort((a, b) -> a.start - b.start);
        int meetingEnd = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            Interval nextMeeting = intervals.get(i);
            if (meetingEnd > nextMeeting.start) {
                return false;
            }
            meetingEnd = nextMeeting.end;
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
