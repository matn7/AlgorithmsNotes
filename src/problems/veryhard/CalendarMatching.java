package problems.veryhard;

import java.util.ArrayList;
import java.util.List;

public class CalendarMatching {

    public static void main(String[] args) {
        List<StringMeeting> calendar1 = new ArrayList<>();
        calendar1.add(new StringMeeting("9:00", "10:30"));
        calendar1.add(new StringMeeting("12:00", "13:00"));
        calendar1.add(new StringMeeting("16:00", "18:00"));

        List<StringMeeting> calendar2 = new ArrayList<>();
        calendar2.add(new StringMeeting("10:00", "11:30"));
        calendar2.add(new StringMeeting("12:30", "14:30"));
        calendar2.add(new StringMeeting("14:30", "15:00"));
        calendar2.add(new StringMeeting("16:00", "17:00"));

        StringMeeting dailyBounds1 = new StringMeeting("9:00", "20:00");
        StringMeeting dailyBounds2 = new StringMeeting("10:00", "18:30");

        int meetingDuration = 30;

        List<StringMeeting> result = calendarMatching(calendar1, dailyBounds1, calendar2, dailyBounds2, meetingDuration);
    }

    // O(c1 + c2) time | O(c1 + c2) space
    public static List<StringMeeting> calendarMatching(
            List<StringMeeting> calendar1,
            StringMeeting dailyBounds1,
            List<StringMeeting> calendar2,
            StringMeeting dailyBounds2,
            int meetingDuration) {
        // Write your code here.
        List<StringMeeting> updatesCalendar1 = updateCalendar(calendar1, dailyBounds1);
        List<StringMeeting> updatesCalendar2 = updateCalendar(calendar2, dailyBounds2);

        List<StringMeeting>  mergedCalendar = mergeCalendars(updatesCalendar1, updatesCalendar2);

        List<StringMeeting> flattenedCalendar = flattenCalendar(mergedCalendar);

        return getMatchingAvailabilities(flattenedCalendar, meetingDuration);
    }

    private static List<StringMeeting> getMatchingAvailabilities(List<StringMeeting> calendar, int meetingDuration) {
        List<StringMeeting> matchingAvailabilities = new ArrayList<>();
        for (int i = 1; i < calendar.size(); i++) {
            String start = calendar.get(i - 1).end;
            String end = calendar.get(i).start;
            int availabilityDuration = Integer.parseInt(end) - Integer.parseInt(start);
            if (availabilityDuration >= meetingDuration) {
                matchingAvailabilities.add(new StringMeeting(start, end));
            }
        }

        List<StringMeeting> matchingAvailabilitiesList = new ArrayList<>();
        for (StringMeeting m : matchingAvailabilities) {
            matchingAvailabilitiesList.add(new StringMeeting(minutesToTime(m.start), minutesToTime(m.end)));
        }
        return matchingAvailabilitiesList;
    }

    private static List<StringMeeting> flattenCalendar(List<StringMeeting> calendar) {
        List<StringMeeting> flattened = new ArrayList<>();
        flattened.add(new StringMeeting(calendar.get(0).start, calendar.get(0).end));
        for (int i = 1; i < calendar.size(); i++) {
            StringMeeting currentMeeting = calendar.get(i);
            StringMeeting previousMeeting = flattened.get(flattened.size()-1);
            String currentStart = currentMeeting.start;
            String currentEnd = currentMeeting.end;
            String previousStart = previousMeeting.start;
            String previousEnd = previousMeeting.end;

            if (Integer.parseInt(previousEnd) >= Integer.parseInt(currentStart)) {
                int max = Math.max(Integer.parseInt(previousEnd), Integer.parseInt(currentEnd));
                StringMeeting newPreviousMeeting = new StringMeeting(previousStart, String.valueOf(max));
                flattened.set(flattened.size() - 1, newPreviousMeeting);
            } else {
                flattened.add(new StringMeeting(currentMeeting.start, currentMeeting.end));
            }
        }
        return flattened;
    }

    private static List<StringMeeting> mergeCalendars(List<StringMeeting> calendar1,
                                                      List<StringMeeting> calendar2) {
        List<StringMeeting> merged = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < calendar1.size() && j < calendar2.size()) {
            StringMeeting meeting1 = calendar1.get(i);
            StringMeeting meeting2 = calendar2.get(j);
            if (Integer.parseInt(meeting1.start) < Integer.parseInt(meeting2.start)) {
                merged.add(meeting1);
                i++;
            } else {
                merged.add(meeting2);
                j++;
            }
        }
        while (i < calendar1.size()) {
            merged.add(calendar1.get(i));
            i++;
        }
        while (j < calendar2.size()) {
            merged.add(calendar2.get(j));
            j++;
        }
        return merged;
    }

    private static List<StringMeeting> updateCalendar(List<StringMeeting> calendar, StringMeeting dailyBounds) {
        List<StringMeeting> updatedCalendar = new ArrayList<>(calendar);
        updatedCalendar.add(new StringMeeting("0:00", dailyBounds.start));
        updatedCalendar.add(new StringMeeting(dailyBounds.end, "23:59"));
        List<StringMeeting> updatedCalendarList = new ArrayList<>();
        for (StringMeeting m : updatedCalendar) {
            updatedCalendarList.add(new StringMeeting(timeToMinutes(m.start), timeToMinutes(m.end)));
        }
        return updatedCalendarList;
    }

    private static String timeToMinutes(String time) {
        int hours = Integer.parseInt(time.split(":")[0]);
        int minutes = Integer.parseInt(time.split(":")[1]);
        return String.valueOf(hours * 60 + minutes);
    }


    private static String minutesToTime(String minutes) {
        int hours = Integer.parseInt(minutes) / 60;
        int mins = Integer.parseInt(minutes) % 60;
        String hoursString = String.valueOf(hours);
        String minutesString;
        if (mins < 10) {
            minutesString = "0" + mins;
        } else {
            minutesString = String.valueOf(mins);
        }
        return hoursString + ":" + minutesString;
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
