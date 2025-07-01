package june_2025;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MeetingRoomsII {

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
//        intervals.add(new Interval(0, 40));
//        intervals.add(new Interval(5, 10));
//        intervals.add(new Interval(15, 20));

        intervals.add(new Interval(1, 5));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(3, 7));
        intervals.add(new Interval(4, 8));
        intervals.add(new Interval(5, 9));

        MeetingRoomsII meetingRoomsII = new MeetingRoomsII();
        int result = meetingRoomsII.minMeetingRooms(intervals);
        System.out.println(result);
    }

    // O(n log(n)) time | O(n) space
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort((a, b) -> {
            if (a.start - b.start == 0) {
                return a.end - b.end;
            }
            return a.start - b.start;
        });

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (Interval interval : intervals) {
            if (minHeap.isEmpty()) {
                minHeap.add(interval.end);
            } else {
                int peek = minHeap.peek(); // 40
                if (peek > interval.start) {
                    minHeap.add(interval.end);
                } else {
                    minHeap.poll();
                    minHeap.add(interval.end);
                }
            }
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
