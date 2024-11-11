package october_2024;

import java.util.*;

public class MeetingRoomsIIV2 {

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(0, 30));
        intervals.add(new Interval(5, 10));
        intervals.add(new Interval(15, 20));

        MeetingRoomsIIV2 meetingRoomsII = new MeetingRoomsIIV2();
        int result = meetingRoomsII.minMeetingRooms(intervals);
        System.out.println(result);

    }

    // O(nlog(n)) time | O(n) space
    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here
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

        int res = 0;
        int count = 0;
        int s = 0;
        int e = 0;

        while (s < start.length) {
            if (start[s] < end[e]) {
                s++;
                count++;
            } else {
                count--;
                e++;
            }
            res = Math.max(res, count);
        }

        return res;
    }


}
