package november_2025;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {

    public static void main(String[] args) {
        int[][] intervals = {{0,30},{5,10},{15,20}};

        MeetingRoomsII meetingRoomsII = new MeetingRoomsII();
        int result = meetingRoomsII.minMeetingRooms(intervals);
        System.out.println(result);

    }

    // O(n * log(n)) time | O(n) space
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int maxOccupied = 0;
        PriorityQueue<Integer> meetingEnd = new PriorityQueue<>();

        for (int[] interval : intervals) {
            if (meetingEnd.isEmpty()) {
                meetingEnd.add(interval[1]);
            } else {
                if (interval[0] >= meetingEnd.peek()) {
                    // need new room
                    meetingEnd.poll();
                }
                meetingEnd.add(interval[1]);
            }

            maxOccupied = Math.max(maxOccupied, meetingEnd.size());
        }

        return maxOccupied;
    }

}
