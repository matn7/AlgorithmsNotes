package december_2025;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {

    // O(n log(n)) time | O(n) space
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> endTime = new PriorityQueue<>();
        endTime.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            int nextMeetingStart = intervals[i][0];
            int currentMeetingEnd = endTime.peek();

            if (nextMeetingStart >= currentMeetingEnd) {
                endTime.poll();
            }
            endTime.add(intervals[i][1]);
        }
        return endTime.size();
    }

}
