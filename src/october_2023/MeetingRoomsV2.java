package october_2023;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsV2 {

    public static void main(String[] args) {
        int[][] meetings = {{20,30}, {0, 50}, {10, 21}, {52,56}, {53,90}};

        meetingRooms(meetings);
    }

    // O(nlog(n)) time | O(n) space
    public static int meetingRooms(int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        // [[0,50], [10,21], [20,30], [52,56], [53,90]]
        //                      *
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int[] meeting : meetings) {
            if (queue.isEmpty()) {
                queue.add(meeting[1]);
            } else {
                Integer queueEnd = queue.peek(); // 21
                if (queueEnd > meeting[0]) {
                    queue.add(meeting[1]);
                } else {
                    queue.poll();
                    queue.add(meeting[1]);
                }
            }
        }

        return queue.size();
    }

}
