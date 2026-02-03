package january_2026;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {

    // O(nlog(n)) time | O(n) space
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            int currentMeetingEnd = minHeap.peek();
            int newMeetingStart = intervals[i][0];
            int newMeetingEnd = intervals[i][1];
            if (newMeetingStart >= currentMeetingEnd) {
                minHeap.poll();
            }
            minHeap.add(newMeetingEnd);
        }

        return minHeap.size();
    }


}
