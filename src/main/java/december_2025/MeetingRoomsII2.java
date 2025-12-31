package december_2025;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII2 {

    // O(nlog(n)) time | O(n) space
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> endTimeMinHeap = new PriorityQueue<>();
        endTimeMinHeap.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            int[] currentMeeting = intervals[i];
            int currStart = currentMeeting[0];
            int currEnd = currentMeeting[1];
            int prevEnd = endTimeMinHeap.peek();

            if (currStart >= prevEnd) {
                endTimeMinHeap.poll();
            }
            endTimeMinHeap.add(currEnd);
        }

        return endTimeMinHeap.size();
    }

}
