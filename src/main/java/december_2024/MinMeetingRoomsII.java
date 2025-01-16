package december_2024;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MinMeetingRoomsII {

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
//        intervals.add(new Interval(0, 40));
//        intervals.add(new Interval(15, 20));
//        intervals.add(new Interval(5, 10));

        intervals.add(new Interval(1, 5));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(3, 7));
        intervals.add(new Interval(5, 9));

        MinMeetingRoomsII minMeetingRooms2 = new MinMeetingRoomsII();
        int result = minMeetingRooms2.minMeetingRooms(intervals);
        System.out.println(result);
    }

    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(a -> a.start));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (Interval interval : intervals) {
            if (minHeap.isEmpty()) {
                minHeap.add(interval.end);
            } else {
                int start = interval.start;
                int end = interval.end;
                if (minHeap.peek() <= start) {
                    minHeap.poll();
                }
                minHeap.add(end);
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
