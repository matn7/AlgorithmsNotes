package june_2025;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MinMeetingRooms {

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(0, 40));
        intervals.add(new Interval(5, 10));
        intervals.add(new Interval(15, 20));

        MinMeetingRooms minMeetingRooms = new MinMeetingRooms();
        int result = minMeetingRooms.minMeetingRooms(intervals);
        System.out.println(result);
    }

    // O(n log(n)) time | O(n) space
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(a -> a.start));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (Interval curr : intervals) {
            if (queue.isEmpty()) {
                queue.add(curr.end);
            } else {
                int start = curr.start;
                int end = curr.end;
                int peek = queue.peek();
                if (peek <= start) {
                    queue.poll();
                }
                queue.add(end);
            }
        }

        return queue.size();
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
