package march_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MeetingRoomII {

    public static void main(String[] args) {
//        List<Interval> intervals = new ArrayList<>();
//        intervals.add(new Interval(0, 30));
//        intervals.add(new Interval(5, 10));
//        intervals.add(new Interval(15, 20));

        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 5));
        intervals.add(new Interval(5, 10));
        intervals.add(new Interval(10, 15));
        intervals.add(new Interval(15, 20));
        intervals.add(new Interval(1, 20));
        intervals.add(new Interval(2, 6));

        MeetingRoomII meetingRoomII = new MeetingRoomII();
        int result = meetingRoomII.minMeetingRooms(intervals);
        System.out.println(result);
    }

    // O(nlog(n)) time | O(n) space
    public int minMeetingRooms(List<Interval> intervals) {
        int[] start = new int[intervals.size()];
        int[] end = new int[intervals.size()];
        for (int i = 0; i < intervals.size(); i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int s = 0;
        int e = 0;
        int max = 0;
        int curr = 0;
        while (s < start.length) {
            if (start[s] < end[e]) {
                curr++;
                s++;
            } else if (start[s] >= end[e]) {
                curr--;
                e++;
            }
            max = Math.max(max, curr);
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
