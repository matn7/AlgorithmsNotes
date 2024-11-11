package october_2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MeetingRooms2 {

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(0, 30));
        intervals.add(new Interval(5, 10));
        intervals.add(new Interval(15, 20));

        MeetingRooms2 meetingRooms = new MeetingRooms2();
        boolean result = meetingRooms.canAttendMeetings(intervals);
        System.out.println(result);
    }

    // O(nlog(n)) time | O(n) space
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals.size() == 1) {
            return true;
        }
        intervals.sort(Comparator.comparingInt(a -> a.start));

        Interval currentMeeting = intervals.get(0);

        for (int i = 1; i < intervals.size(); i++) {
            Interval nextMeeting = intervals.get(i);
            if (currentMeeting.end > nextMeeting.start) {
                return false;
            }
            currentMeeting = nextMeeting;
        }
        return true;
    }

}

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

