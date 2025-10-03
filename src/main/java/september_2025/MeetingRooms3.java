package september_2025;

import java.util.List;

public class MeetingRooms3 {

    // O(nlog(n)) time | O(n) space
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals.isEmpty()) {
            return true;
        }
        intervals.sort((a, b) -> a.start - b.start);

        int prevEnd = intervals.get(0).end;

        for (int i = 1; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            int currStart = curr.start;
            if (prevEnd > currStart) {
                return false;
            }
            prevEnd = curr.end;
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
