package september_2025;

import java.util.List;
import java.util.PriorityQueue;

public class MeetingRooms2II {

    // O(nlog(n)) time | O(n) space
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals.isEmpty()) {
            return 0;
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        intervals.sort((a, b) -> a.start - b.start);

        minHeap.add(intervals.get(0).end);

        for (int i = 1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            if (current.start >= minHeap.peek()) {
                minHeap.poll();
            }
            minHeap.add(current.end);
        }
        return minHeap.size();
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
