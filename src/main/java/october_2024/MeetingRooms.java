package october_2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MeetingRooms {

    public static void main(String[] args) {
        List<List<Integer>> intervals = new ArrayList<>();
        intervals.add(Arrays.asList(12, 14));
        intervals.add(Arrays.asList(5, 10));
        intervals.add(Arrays.asList(15, 20));

        MeetingRooms meetingRooms = new MeetingRooms();
        boolean result = meetingRooms.meetingRooms(intervals);
        System.out.println(result);
    }

    // O(nlog(n)) time | O(n) space
    public boolean meetingRooms(List<List<Integer>> intervals) {
        intervals.sort(Comparator.comparingInt(a -> a.get(0)));

        List<List<Integer>> meetings = new ArrayList<>();

        for (List<Integer> interval : intervals) {
            if (meetings.isEmpty()) {
                meetings.add(interval);
            } else {
                List<Integer> currentMeeting = meetings.get(meetings.size() - 1); // 0- - 30
                if (currentMeeting.get(1) > interval.get(0)) {
                    return false;
                } else {
                    meetings.add(interval);
                }
            }
        }
        return true;
    }

    // O(nlog(n)) time | O(n) space
    public boolean meetingRooms2(List<List<Integer>> intervals) {
        if (intervals.size() == 1) {
            return true;
        }
        intervals.sort(Comparator.comparingInt(a -> a.get(0)));

        List<Integer> currentMeeting = intervals.get(0);

        for (int i = 1; i < intervals.size(); i++) {
            List<Integer> nextMeeting = intervals.get(i);
            if (currentMeeting.get(1) > nextMeeting.get(0)) {
                return false;
            }
            currentMeeting = nextMeeting;
        }
        return true;
    }

}
