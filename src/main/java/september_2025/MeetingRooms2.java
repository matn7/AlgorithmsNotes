package september_2025;

import java.util.List;

public class MeetingRooms2 {

    // O(nlog(n)) time | O(n) space
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals.isEmpty()) {
            return true;
        }

        intervals.sort((a, b) -> a.start - b.start);

        int currEnd = intervals.get(0).end; // 30
        for (int i = 1; i < intervals.size(); i++) {
            Interval newMeeting = intervals.get(i);
            if (newMeeting.start < currEnd) {
                return false;
            }
            currEnd = newMeeting.end;
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
