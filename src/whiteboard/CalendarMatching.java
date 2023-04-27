package whiteboard;

import java.util.ArrayList;
import java.util.List;

public class CalendarMatching {

    public static void main(String[] args) {
        List<StringMeeting> calendar1 = new ArrayList<>();
        calendar1.add(new StringMeeting("9:00", "10:30"));
        calendar1.add(new StringMeeting("12:00", "13:00"));
        calendar1.add(new StringMeeting("16:00", "18:00"));

        StringMeeting dailyBounds1 = new StringMeeting("9:00", "20:00");

        List<StringMeeting> calendar2 = new ArrayList<>();
        calendar2.add(new StringMeeting("10:00", "11:30"));
        calendar2.add(new StringMeeting("12:30", "14:30"));
        calendar2.add(new StringMeeting("14:30", "15:00"));
        calendar2.add(new StringMeeting("16:00", "17:00"));

        StringMeeting dailyBounds2 = new StringMeeting("10:00", "18:30");

        int meetingDuration = 30;

        calendarMatching(calendar1, dailyBounds1, calendar2, dailyBounds2, meetingDuration);
    }

    // O(c1 + c2) time | O(c1 + c2) space
    public static List<StringMeeting> calendarMatching(
            List<StringMeeting> calendar1,
            StringMeeting dailyBounds1,
            List<StringMeeting> calendar2,
            StringMeeting dailyBounds2,
            int meetingDuration) {
        // Write your code here.
        List<Integer[]> hoursToMinutesCal1 = generateCalendar(calendar1);
        Integer[] hoursToMinutesBounds1 = convertHoursToMinutes(dailyBounds1);
        List<Integer[]> hoursToMinutesCal2 = generateCalendar(calendar2);
        Integer[] hoursToMinutesBounds2 = convertHoursToMinutes(dailyBounds2);

        List<Integer[]> merged = mergeCalendars(hoursToMinutesCal1, hoursToMinutesCal2);

        Integer[] mergeDailyBounds = mergeBounds(hoursToMinutesBounds1, hoursToMinutesBounds2);

        List<Integer[]> freeSlots = findFreeSlots(merged, mergeDailyBounds);

        List<StringMeeting> result = generateMinutesCalendar(freeSlots);

        return result;
    }

    private static List<StringMeeting> generateMinutesCalendar(List<Integer[]> freeSlots) {
        List<StringMeeting> result = new ArrayList<>();

        for (Integer[] slot : freeSlots) {
            StringMeeting newSlot = convertMinutesToHours(slot);
            result.add(newSlot);
        }
        return result;
    }

    private static StringMeeting convertMinutesToHours(Integer[] slot) {
        int start = slot[0];
        int end = slot[1];
        int startHour = start / 60;
        int startMinutes = start % 60;
        int endHour = end / 60;
        int endMinutes = end % 60;
        String startMinutesString = startMinutes == 0 ? "00" : String.valueOf(startMinutes);
        String newStart = startHour + ":" + startMinutesString;
        String endMinutesString = endMinutes == 0 ? "00" : String.valueOf(endMinutes);
        String newEnd = endHour + ":" + endMinutesString;
        return new StringMeeting(newStart, newEnd);
    }

    private static List<Integer[]> findFreeSlots(List<Integer[]> merged, Integer[] dailyBounds) {
        List<Integer[]> result = new ArrayList<>();
        Integer[] prev = merged.remove(0);
        Integer[] curr = new Integer[2];
        while (!merged.isEmpty()) {
            curr = merged.remove(0);
            if (isWithinBounds(prev[1], curr[0], dailyBounds)) {
                result.add(new Integer[] {prev[1], curr[0]});
                prev = curr;
            }
        }
        if (curr[1] <= dailyBounds[1]) {
            result.add(new Integer[]{ curr[1], dailyBounds[1]});
        }
        return result;
    }

    private static boolean isWithinBounds(Integer start, Integer end, Integer[] bounds) {
        return start > bounds[0] && start < bounds[1] && end > bounds[0] && end < bounds[1];
    }

    private static Integer[] mergeBounds(Integer[] bound1, Integer[] bound2) {
        int start = Math.max(bound1[0], bound2[0]);
        int end = Math.min(bound1[1], bound2[1]);
        return new Integer[] {start, end};
    }

    private static List<Integer[]> mergeCalendars(List<Integer[]> calendar1, List<Integer[]> calendar2) {
        List<Integer[]> merged = new ArrayList<>();
        if (calendar1.get(0)[0] < calendar2.get(0)[0]) {
            merged.add(calendar1.remove(0));
        } else {
            merged.add(calendar2.remove(0));
        }

        while (!calendar1.isEmpty() && !calendar2.isEmpty())  {
            Integer[] curr = merged.get(merged.size() - 1);
            Integer[] one = calendar1.get(0);
            Integer[] two = calendar2.get(0);
            if (two[0] < one[0]) {
                two = calendar2.remove(0);
                if (curr[1] >= two[0]) {
                    curr[1] = Math.max(curr[1], two[1]);
                } else {
                    merged.add(two);
                }
            } else {
                one = calendar1.remove(0);
                if (curr[1] >= one[0]) {
                    curr[1] = Math.max(curr[1], one[1]);
                } else {
                    merged.add(one);
                }
            }
        }

        while (!calendar1.isEmpty()) {
            Integer[] curr = merged.get(merged.size() - 1);
            Integer[] one = calendar1.remove(0);
            if (curr[1] > one[0]) {
                curr[1] = Math.max(curr[1], one[1]);
            } else {
                merged.add(one);
            }
        }

        while (!calendar2.isEmpty()) {
            Integer[] curr = merged.get(merged.size() - 1);
            Integer[] two = calendar2.remove(0);
            if (curr[1] > two[0]) {
                curr[1] = Math.max(curr[1], two[1]);
            } else {
                merged.add(two);
            }
        }
        return merged;
    }

    private static Integer[] convertHoursToMinutes(StringMeeting meeting) {
        String start = meeting.start;
        String end = meeting.end;
        String[] startSplit = start.split(":");
        String[] endSplit = end.split(":");
        int startMins = 60 * Integer.parseInt(startSplit[0]) + Integer.parseInt(startSplit[1]);
        int endMins = 60 * Integer.parseInt(endSplit[0]) + Integer.parseInt(endSplit[1]);
        return new Integer[] {startMins, endMins};
    }

    private static List<Integer[]> generateCalendar(List<StringMeeting> calendar) {
        List<Integer[]> result = new ArrayList<>();
        for (StringMeeting meeting : calendar) {
            Integer[] bounds = convertHoursToMinutes(meeting);
            result.add(bounds);
        }
        return result;
    }

    static class StringMeeting {
        public String start;
        public String end;

        public StringMeeting(String start, String end) {
            this.start = start;
            this.end = end;
        }
    }

}
