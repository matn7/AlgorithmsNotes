package veryhard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalendarMatchingREPEAT {

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

    // OK - repeated 20/02/2022
    // O(c1 + c2) time | O(c1 + c2) space
    public static List<StringMeeting> calendarMatching(
            List<StringMeeting> calendar1,
            StringMeeting dailyBounds1,
            List<StringMeeting> calendar2,
            StringMeeting dailyBounds2,
            int meetingDuration) {
        // Write your code here.
        // calendar1    = [("9:00","10:30"), ("12:00","13:00"), ("16:00","18:00")]
        // dailyBounds1 = ("9:00","20:00")
        // calendar2    = [("10:00","11:30"), ("12:30","14:30"), ("14:30","15:00"), ("16:00","17:00")]
        // dailyBounds2 = ("10:00","18:30")

        // rec([("9:00","10:30"), ("12:00","13:00"), ("16:00","18:00")], ("9:00","20:00"))
        List<StringMeeting> updatedCalendar1 = updateCalendar(calendar1, dailyBounds1);
        // updatedCalendar1 = [("0","540"), ("540","630"), ("720","780"), ("960","1080"), ("1200","1439")]

        // rec([("10:00","11:30"), ("12:30","14:30"), ("14:30","15:00"), ("16:00","17:00")], ("10:00","18:30"))
        List<StringMeeting> updatedCalendar2 = updateCalendar(calendar2, dailyBounds2);
        // updatedCalendar2 = [("0","600"), ("600","690"), ("750","870"), ("870","900"), ("960","1020"), ("1110","1439")]

        // rec([("0","540"), ("540","630"), ("720","780"), ("960","1080"), ("1200","1439")],
        //     [("0","600"), ("600","690"), ("750","870"), ("870","900"), ("960","1020"), ("1110","1439")])
        List<StringMeeting> mergedCalendar = mergeCalendar(updatedCalendar1, updatedCalendar2);
        // mergedCalendar = [("0","600"), ("0","540"), ("540","630"), ("600","690"), ("720","780"), ("750","870"),
        // ("870","900"), ("960","1020"), ("960","1080"), ("1110","1439"), ("1200","1439")]

        // rec(mergedCalendar)
        List<StringMeeting> flattenedCalendar = flattenCalendar(mergedCalendar);
        // flattenedCalendar = [("0","690"), ("720","900"), ("960","1080"), ("1110","1439")]
        // rec([("0","690"), ("720","900"), ("960","1080"), ("1110","1439")], 30)
        // [("11:30","12:00"), ("15:00","16:00"), ("18:00","18:30")]
        return getMatchingAvailabilities(flattenedCalendar, meetingDuration);
    }

    // rec([("10:00","11:30"), ("12:30","14:30"), ("14:30","15:00"), ("16:00","17:00")], ("10:00","18:30"))
    private static List<StringMeeting> updateCalendar(List<StringMeeting> calendar, StringMeeting dailyBounds) {
        List<StringMeeting> updatedCalendar = new ArrayList<>(calendar);
        updatedCalendar.add(0, new StringMeeting("0:00", dailyBounds.start));
        updatedCalendar.add(new StringMeeting(dailyBounds.end, "23:59"));
        // updatedCalendar = [("0:00","10:00"), ("10:00","11:30"), ("12:30","14:30"),
        //                    ("14:30","15:00"), ("16:00","17:00"), ("18:30","23:59")]
        List<StringMeeting> result = new ArrayList<>();
        for (StringMeeting m : updatedCalendar) {
            result.add(new StringMeeting(timeToMinutes(m.start), timeToMinutes(m.end)));
        }
        return result; // [("0","600"), ("600","690"), ("750","870"), ("870","900"), ("960","1020"), ("1110","1439")]
    }

    // rec([("0","540"), ("540","630"), ("720","780"), ("960","1080"), ("1200","1439")],
    //     [("0","600"), ("600","690"), ("750","870"), ("870","900"), ("960","1020"), ("1110","1439")])
    private static List<StringMeeting> mergeCalendar(List<StringMeeting> calendar1, List<StringMeeting> calendar2) {
        List<StringMeeting> merged = new ArrayList<>();
        int i = 0;
        int j = 0;
        //                                                                                 i
        // calendar1 = [("0","540"), ("540","630"), ("720","780"), ("960","1080"), ("1200","1439")]
        //                                                                                                            j
        // calendar2 = [("0","600"), ("600","690"), ("750","870"), ("870","900"), ("960","1020"), ("1110","1439")]
        while (i < calendar1.size() && j < calendar2.size()) {
            StringMeeting meeting1 = calendar1.get(i); // ("1200","1439")
            StringMeeting meeting2 = calendar2.get(j); // ("1110","1439")
            if (Integer.parseInt(meeting1.start) < Integer.parseInt(meeting2.start)) { // 1200 < 1110
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

        return merged; // [("0","600"), ("0","540"), ("540","630"), ("600","690"), ("720","780"), ("750","870"),
        // ("870","900"), ("960","1020"), ("960","1080"), ("1110","1439"), ("1200","1439")]
    }
    //          *
    // rec([("0","600"), ("0","540"), ("540","630"), ("600","690"), ("720","780"), ("750","870"),
    //                                                                         i
    //  ("870","900"), ("960","1020"), ("960","1080"), ("1110","1439"), ("1200","1439")])
    private static List<StringMeeting> flattenCalendar(List<StringMeeting> calendar) {
        List<StringMeeting> flattened = new ArrayList<>(Arrays.asList(calendar.get(0)));
        // flattened = [("0","690"), ("720","900"), ("960","1080"), ("1110","1439")]
        for (int i = 1; i < calendar.size(); i++) {
            StringMeeting currentMeeting = calendar.get(i); // ("1200","1439")
            StringMeeting previousMeeting = flattened.get(flattened.size() - 1); // ("1110","1439")
            String currentStart = currentMeeting.start; // 1200
            String currentEnd = currentMeeting.end; // 1439
            String previousStart = previousMeeting.start; // 1110
            String previousEnd = previousMeeting.end; // 1439
            if (Integer.parseInt(previousEnd) >= Integer.parseInt(currentStart)) {  // 1439 >= 1200
                int max = Math.max(Integer.parseInt(previousEnd), Integer.parseInt(currentEnd)); // max(1439, 1439) = 1439
                StringMeeting newPreviousMeeting = new StringMeeting(previousStart, String.valueOf(max)); // ("1110","1439")
                flattened.set(flattened.size() - 1, newPreviousMeeting);
            } else {
                flattened.add(currentMeeting);
            }
        }
        return flattened;
    }
    //                                                         i
    // rec([("0","690"), ("720","900"), ("960","1080"), ("1110","1439")], 30)
    private static List<StringMeeting> getMatchingAvailabilities(List<StringMeeting> calendar,
                                                                 int meetingDuration) {
        List<StringMeeting> matchingAvailabilities = new ArrayList<>();
        for (int i = 1; i < calendar.size(); i++) {
            String start = calendar.get(i - 1).end; // 1080
            String end = calendar.get(i).start; // 1110
            int availabilityDuration = Integer.parseInt(end) - Integer.parseInt(start); // 1110 - 1080 = 30
            if (availabilityDuration >= meetingDuration) { // 30 >= 30
                matchingAvailabilities.add(new StringMeeting(start, end));
            }
        }
        // matchingAvailabilities = [("690","720"), ("900","960"), ("1080","1110")]
        List<StringMeeting> result = new ArrayList<>();
        for (StringMeeting m : matchingAvailabilities) {
            // rec(900)
            result.add(new StringMeeting(minutesToTime(m.start), minutesToTime(m.end)));
        }
        return result; // [("11:30","12:00"), ("15:00","16:00"), ("18:00","18:30")]
    }

    // rec(1110)
    private static String minutesToTime(String minutes) {
        int hours = Integer.parseInt(minutes) / 60; // 1110 / 60 = 18
        int mins = Integer.parseInt(minutes) % 60;  // 1110 % 60 = 30
        String hoursString = String.valueOf(hours); // 18
        String minutesString = mins < 10 ? "0" + mins : String.valueOf(mins); // 30
        return hoursString + ":" + minutesString; // 18:30
    }

    // ("9:00","10:30")
    private static String timeToMinutes(String time) {
        String[] hoursMinutes = time.split(":");
        int hours = Integer.parseInt(hoursMinutes[0]); // 10
        int minutes = Integer.parseInt(hoursMinutes[1]); // 30
        return String.valueOf(hours * 60 + minutes); // 10 * 60 + 30 = 630
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
