package december_2024;

import java.util.*;

public class MinMeetingRoomsII2 {

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(0, 40));
        intervals.add(new Interval(15, 20));
        intervals.add(new Interval(5, 10));

//        intervals.add(new Interval(1, 5));
//        intervals.add(new Interval(2, 6));
//        intervals.add(new Interval(3, 7));
//        intervals.add(new Interval(5, 9));

        MinMeetingRoomsII2 minMeetingRooms2 = new MinMeetingRoomsII2();
        int result = minMeetingRooms2.minMeetingRooms(intervals);
        System.out.println(result);
    }

    public int minMeetingRooms(List<Interval> intervals) {
        int[] start = new int[intervals.size()];
        int[] end = new int[intervals.size()];

        int idx = 0;
        for (Interval interval : intervals) {
            start[idx] = interval.start;
            end[idx] = interval.end;
            idx++;
        }
        Arrays.sort(start);
        Arrays.sort(end);

        int i =0;
        int j = 0;
        int count = 0;
        int max = 0;
        while (i < start.length) {
            if (start[i] < end[j]) {
                count++;
                i++;
            } else if (start[i] == end[j]) {
                i++;
                j++;
            } else {
                count--;
                j++;
            }
            max = Math.max(max, count);
        }
        return max;
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
