package january_2026;

import java.util.Arrays;

public class MeetingRooms {

    // O(n log(n)) time | O(n) space
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length == 0) {
            return true;
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int endTime = intervals[0][1]; // [2, 4] -> 4

        for (int i = 1; i < intervals.length; i++) {
            int currStart = intervals[i][0]; // [7, 10]
            if (endTime > currStart) { // 4 > 10
                return false;
            }
            endTime = intervals[i][1]; // 10
        }
        return true;
    }

}
