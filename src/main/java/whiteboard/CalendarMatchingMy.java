package whiteboard;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CalendarMatchingMy {

    public static void main(String[] args) {
        List<StringMeeting> calendar1 = new ArrayList<>();
//        calendar1.add(new StringMeeting("9:00", "10:30"));
//        calendar1.add(new StringMeeting("12:00", "13:00"));
//        calendar1.add(new StringMeeting("16:00", "18:00"));

        calendar1.add(new StringMeeting("7:00", "7:45"));
        calendar1.add(new StringMeeting("8:15", "8:30"));
        calendar1.add(new StringMeeting("9:00", "10:30"));
        calendar1.add(new StringMeeting("12:00", "14:00"));
        calendar1.add(new StringMeeting("14:00", "15:00"));
        calendar1.add(new StringMeeting("15:15", "15:30"));
        calendar1.add(new StringMeeting("16:30", "18:30"));
        calendar1.add(new StringMeeting("20:00", "21:00"));

        StringMeeting dailyBounds1 = new StringMeeting("6:30", "22:00");

        List<StringMeeting> calendar2 = new ArrayList<>();
//        calendar2.add(new StringMeeting("10:00", "11:30"));
//        calendar2.add(new StringMeeting("12:30", "14:30"));
//        calendar2.add(new StringMeeting("14:30", "15:00"));
//        calendar2.add(new StringMeeting("16:00", "17:00"));

        calendar2.add(new StringMeeting("9:00", "10:00"));
        calendar2.add(new StringMeeting("11:15", "11:30"));
        calendar2.add(new StringMeeting("11:45", "17:00"));
        calendar2.add(new StringMeeting("17:30", "19:00"));
        calendar2.add(new StringMeeting("20:00", "22:15"));

        StringMeeting dailyBounds2 = new StringMeeting("8:00", "22:30");

        calendarMatching(calendar1, dailyBounds1, calendar2, dailyBounds2, 30);

    }

    // O(c1 + c2) time | O(c1 + c2) space
    public static List<StringMeeting> calendarMatching(
            List<StringMeeting> calendar1,
            StringMeeting dailyBounds1,
            List<StringMeeting> calendar2,
            StringMeeting dailyBounds2,
            int meetingDuration) {
        // Write your code here.
        Integer[] numberDailyBounds1 = processMeeting(dailyBounds1);
        Integer[] numberDailyBounds2 = processMeeting(dailyBounds2);
        if (calendar1.isEmpty() && calendar2.isEmpty()) {
            Integer[] bounds = new Integer[] {
                    Math.max(numberDailyBounds1[0], numberDailyBounds2[0]),
                    Math.min(numberDailyBounds1[1], numberDailyBounds2[1])
            };
            StringMeeting stringMeeting = processMeeting(bounds);
            List<StringMeeting> result = new ArrayList<>();
            result.add(stringMeeting);
            return result;
        }
        List<Integer[]> numberBounds1 = createBounds(calendar1);
        List<Integer[]> numberBounds2 = createBounds(calendar2);
        List<Integer[]> mergeBounds = mergeBounds(numberBounds1, numberBounds2);

        Integer[] dailyBounds = new Integer[] {
                        Math.max(numberDailyBounds1[0], numberDailyBounds2[0]),
                        Math.min(numberDailyBounds1[1], numberDailyBounds2[1])};
//        Integer[] first = mergeBounds.get(0);
//        Integer[] last = mergeBounds.get(mergeBounds.size() - 1);
//        first[0] = Math.max(first[0], dailyBounds[0]);
//        last[1] = Math.min(last[1], dailyBounds[1]);
        List<Integer[]> gaps = findGaps(mergeBounds, meetingDuration, dailyBounds);
        // [[600,690], [720,870], [870,900], [960,1080]]
        List<StringMeeting> calendarGaps = processGaps(gaps);
        return calendarGaps;
    }

    private static List<Integer[]> createBounds(List<StringMeeting> calendar) {
        List<Integer[]> result = new ArrayList<>();
        for (StringMeeting meeting : calendar) {
            Integer[] meetingBound = processMeeting(meeting);
            result.add(meetingBound);
        }
        return result;
    }

    private static Integer[] processMeeting(StringMeeting meeting) {
        String start = meeting.start;
        String end = meeting.end;
        String[] startSplit = start.split(":");
        String[] endSplit = end.split(":");

        int startNum = Integer.parseInt(startSplit[0]) * 60 + Integer.parseInt(startSplit[1]);
        int endNum = Integer.parseInt(endSplit[0]) * 60 + Integer.parseInt(endSplit[1]);

        return new Integer[] {startNum, endNum};
    }

    private static List<Integer[]> mergeBounds(List<Integer[]> numberBounds1, List<Integer[]> numberBounds2) {
        List<Integer[]> result = new ArrayList<>();
        List<Integer[]> bounds = new ArrayList<>();
        bounds.addAll(numberBounds1);
        bounds.addAll(numberBounds2);
        bounds.sort(Comparator.comparing(a -> a[0]));

        for (int i = 0; i < bounds.size(); i++) {
            if (result.isEmpty()) {
                result.add(bounds.get(i));
            } else {
                Integer[] current = bounds.get(i); // [600, 690]
                Integer[] top = result.get(result.size() - 1); // [540, 630]

                if (top[1] > current[0]) {
                    top[1] = Math.max(top[1], current[1]);
                } else {
                    result.add(current);
                }
            }
        }
        return result;
    }


    private static List<Integer[]> findGaps(List<Integer[]> bounds, int meetingDuration, Integer[] dailyBounds) {
        // [[600,690], [720,870], [870,900], [960,1080]]
        // [[600, 1110]]
        List<Integer[]> result = new ArrayList<>();
        int prev = 0;
        /// check whether we have a time before day
        if (bounds.get(0)[0] - dailyBounds[0] >= meetingDuration) {
            result.add(new Integer[]{dailyBounds[0], bounds.get(0)[0]});
        }
        for (int curr = 1; curr < bounds.size(); curr++) {
            Integer[] previous = bounds.get(prev);
            Integer[] current = bounds.get(curr);
            if (current[0] - previous[1] >= meetingDuration && previous[1] >= dailyBounds[0]) {
                result.add(new Integer[]{previous[1], current[0]});
            }
            prev = curr;
        }
        // check whether we have time after day
        if (dailyBounds[1] - bounds.get(bounds.size() - 1)[1] >= meetingDuration) {
            result.add(new Integer[]{bounds.get(bounds.size() - 1)[1], dailyBounds[1]});
        }

        return result;
    }

    private static List<StringMeeting> processGaps(List<Integer[]> gaps) {
        List<StringMeeting> result = new ArrayList<>();
        // [[690,720],[900,960],[1080,1110]]
        for (Integer[] gap : gaps) {
            result.add(processMeeting(gap));
        }
        return result;
    }

    private static StringMeeting processMeeting(Integer[] bounds) {
        Integer gapStart = bounds[0];
        Integer gapEnd = bounds[1];
        Integer gapStartHour = gapStart / 60;
        int gapStartMinute = gapStart % 60;
        String stringMinute = gapStartMinute == 0 ? "00" : String.valueOf(gapStartMinute);
        String start = gapStartHour + ":" + stringMinute;

        Integer gapEndHour = gapEnd / 60;
        int gapEndMinute = gapEnd % 60;
        String stringHour = gapEndMinute == 0 ? "00" : String.valueOf(gapEndMinute);
        String end = gapEndHour + ":" + stringHour;
        return new StringMeeting(start, end);
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
