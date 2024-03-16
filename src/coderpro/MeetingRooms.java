package coderpro;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

public class MeetingRooms {

    public static void main(String[] args) {
        Integer[][] meetings = {{20, 30}, {0, 50}, {10, 21}, {52, 56}, {58, 90}, {100, 101}, {102, 103}, {105, 1010}};

        MeetingRooms meetingRooms = new MeetingRooms();
        int result = meetingRooms.meeting_rooms(meetings);
        System.out.println(result);
    }

    // O(nlog(n)) time | O(n) space
    public int meeting_rooms(Integer[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> meeting_ends = new PriorityQueue<>();
        int max_rooms = 0;

        for (Integer[] meeting : meetings) {
            while (!meeting_ends.isEmpty() && meeting_ends.peek() <= meeting[0]) {
                meeting_ends.poll();
            }
            meeting_ends.add(meeting[1]);
            max_rooms = Math.max(max_rooms, meeting_ends.size());
        }

        return max_rooms;
    }

    // O(nlog(n)) + O(n) + O(nlog(n)) = O(nlog(n)) time | O(n) space
    public int meetingRooms(Integer[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Meeting> queue = new PriorityQueue<>();

        for (Integer[] meeting : meetings) {
            if (queue.isEmpty()) {
                queue.add(new Meeting(meeting[0], meeting[1]));
            } else {
                Meeting current = queue.peek(); // [10, 19]
                // meeting [20, 30]
                if (current.end > meeting[0]) { // 19 > 20
                    queue.add(new Meeting(meeting[0], meeting[1]));
                } else {
                    queue.poll();
                    queue.add(new Meeting(meeting[0], meeting[1]));
                }
            }
        }

        //      [10, 21]
        // [0, 50]    [20, 30]

        return queue.size();
    }

}

class Meeting implements Comparable<Meeting> {
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Meeting o) {
        return this.end - o.end;
    }
}