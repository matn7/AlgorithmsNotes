package september_2025;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MeetingRoomsII {

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(0, 40));
        intervals.add(new Interval(5, 10));
        intervals.add(new Interval(15, 20));

        MeetingRoomsII meetingRooms = new MeetingRoomsII();
        int result = meetingRooms.minMeetingRooms(intervals);
        System.out.println(result);
    }

    // O(nlog(n)) time | O(n) space
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals.isEmpty()) {
            return 0;
        }

        intervals.sort((a, b) -> a.start - b.start);

        PriorityQueue<Integer> meetingEnds = new PriorityQueue<>();
        meetingEnds.add(intervals.get(0).end);

        for (int i = 1; i < intervals.size(); i++) {
            Interval nextMeeting = intervals.get(i);
            int currentMeeting = meetingEnds.peek();
            if (nextMeeting.start >= currentMeeting) {
                meetingEnds.poll();
            }
            meetingEnds.add(nextMeeting.end);
        }

        return meetingEnds.size();
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
