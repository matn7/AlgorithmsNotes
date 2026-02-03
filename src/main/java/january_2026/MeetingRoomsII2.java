package january_2026;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII2 {

    // O(nlog(n)) time | O(n) space
    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<Integer> meetingEndsTime = new PriorityQueue<>(); // minHeap
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        meetingEndsTime.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            int currMeetingEnd = meetingEndsTime.peek();
            int newMeetingStart = intervals[i][0];

            if (currMeetingEnd <= newMeetingStart) {
                // free currently occupier room
                meetingEndsTime.poll();
            }
            meetingEndsTime.add(intervals[i][1]);
        }

        return meetingEndsTime.size();
    }

}
