package january_2024;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms {

    public static void main(String[] args) {
        int[][] meetings = {{0, 50}, {10, 21}, {20, 30}, {15, 18}};

        meetingRooms(meetings);
    }

    // O(nlog(n)) time | O(n) space
    public static int meetingRooms(int[][] meetings) {
        if (meetings.length == 0) {
            return 0;
        }
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0])); // O(nlog(n)) time

        PriorityQueue<Integer> meetingsEnd = new PriorityQueue<>();

        for (int[] meeting : meetings) {
            if (meetingsEnd.isEmpty()) {
                meetingsEnd.add(meeting[1]);
            } else {
                Integer queueEnd = meetingsEnd.peek(); // 50
                int currStart = meeting[0]; // 10
                int currEnd = meeting[1];
                if (queueEnd > currStart) {
                    meetingsEnd.add(currEnd);
                } else {
                    meetingsEnd.poll();
                    meetingsEnd.add(currEnd);
                }
            }
        }

        return meetingsEnd.size();
    }

}
