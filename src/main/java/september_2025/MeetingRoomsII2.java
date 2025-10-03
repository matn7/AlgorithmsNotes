package september_2025;

import java.util.List;
import java.util.PriorityQueue;

public class MeetingRoomsII2 {

    // O(nlog(n)) time | O(n) space
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals.isEmpty()) {
            return 0;
        }
        intervals.sort((a, b) -> a.start - b.start);
        PriorityQueue<Integer> endTime = new PriorityQueue<>();
        endTime.add(intervals.get(0).end);

        for (int i = 1; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            int prevEnd = endTime.peek();
            if (curr.start >= prevEnd) {
                endTime.poll();
            }
            endTime.add(curr.end);
        }

        return endTime.size();
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
