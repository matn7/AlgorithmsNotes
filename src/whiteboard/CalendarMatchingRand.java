package whiteboard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CalendarMatchingRand {

    public static void main(String[] args) {
        List<StringMeeting> calendar1 = new ArrayList<>();
        calendar1.add(new StringMeeting("9:00", "10:30"));
        calendar1.add(new StringMeeting("12:00", "13:00"));
        calendar1.add(new StringMeeting("16:00", "18:00"));

        StringMeeting dailyBounds1 = new StringMeeting("7:00", "20:00");

        List<StringMeeting> calendar2 = new ArrayList<>();
        calendar2.add(new StringMeeting("10:00", "11:30"));
        calendar2.add(new StringMeeting("12:30", "14:30"));
        calendar2.add(new StringMeeting("14:30", "15:00"));
        calendar2.add(new StringMeeting("16:00", "17:00"));

        StringMeeting dailyBounds2 = new StringMeeting("5:00", "18:30");

        int meetingDuration = 30;

        calendarMatching(calendar1, dailyBounds1, calendar2, dailyBounds2, meetingDuration);
    }

    public static List<StringMeeting> calendarMatching(
            List<StringMeeting> calendar1,
            StringMeeting dailyBounds1,
            List<StringMeeting> calendar2,
            StringMeeting dailyBounds2,
            int meetingDuration) {
        // Write your code here.
        List<Integer> bounds = getBounds(dailyBounds1, dailyBounds2);
        List<List<Integer>> merged = mergeIntervals(prepareIntervals(calendar1), prepareIntervals(calendar2));
        List<List<Integer>> findGaps = findGaps(merged, bounds, meetingDuration);

        return convertGapsToMeeting(findGaps);
    }

    private static List<StringMeeting> convertGapsToMeeting(List<List<Integer>> gaps) {
        List<StringMeeting> matchingList = new ArrayList<>();

        for (List<Integer> meeting : gaps) {
            StringMeeting stringMeeting = convertIntervalToMeeting(meeting);
            matchingList.add(stringMeeting);
        }

        return matchingList;
    }

    private static StringMeeting convertIntervalToMeeting(List<Integer> meeting) {
        Integer start = meeting.get(0);
        Integer end = meeting.get(1);
        int startHour = start / 60;
        int startMinutes = start % 60;
        String startMins = startMinutes == 0 ? "00" : startMinutes + "";
        String startTime = startHour + ":" + startMins;
        int endHour = end / 60;
        int endMinutes = end % 60;
        String endMins = endMinutes == 0 ? "00" : endMinutes + "";
        String endTime = endHour + ":" + endMins;
        StringMeeting stringMeeting = new StringMeeting(startTime, endTime);
        return stringMeeting;
    }

    private static List<List<Integer>> findGaps(List<List<Integer>> merged, List<Integer> bounds, int meetingDuration) {
        List<List<Integer>> gaps = new ArrayList<>();

        List<Integer> startMerge = merged.get(0);
        startMerge.set(0, Math.max(startMerge.get(0), bounds.get(0)));
        List<Integer> endMerge = merged.get(merged.size() - 1);
        endMerge.set(1, Math.min(endMerge.get(1), bounds.get(1)));

        if (startMerge.get(0) - bounds.get(0) >= meetingDuration) {
            List<Integer> gap = new ArrayList<>();
            gap.add(bounds.get(0));
            gap.add(startMerge.get(0));
            gaps.add(gap);
        }

        for (int i = 1; i < merged.size(); i++) {
            List<Integer> prev = merged.get(i - 1);
            List<Integer> curr = merged.get(i);
            if (curr.get(0) - prev.get(1) >= meetingDuration) {
                List<Integer> gap = new ArrayList<>();
                gap.add(prev.get(1));
                gap.add(curr.get(0));
                gaps.add(gap);
            }
        }
        if (bounds.get(1) - endMerge.get(1) >= meetingDuration) {
            List<Integer> gap = new ArrayList<>();
            gap.add(endMerge.get(1));
            gap.add(bounds.get(1));
            gaps.add(gap);
        }
        return gaps;
    }

    private static List<List<Integer>> mergeIntervals(List<List<Integer>> interval1, List<List<Integer>> interval2) {
        List<List<Integer>> merged = new ArrayList<>();
        List<List<Integer>> allIntervals = mergeIntervalsArrays(interval1, interval2);

        for (List<Integer> interval : allIntervals) {
            if (merged.isEmpty()) {
                merged.add(interval);
            } else {
                List<Integer> current = merged.get(merged.size() - 1);
                if (interval.get(0) <= current.get(1)) {
                    current.set(1, Math.max(interval.get(1), current.get(1)));
                } else {
                    merged.add(interval);
                }
            }
        }

        return merged;
    }

    private static List<List<Integer>> mergeIntervalsArrays(List<List<Integer>> interval1, List<List<Integer>> interval2) {
        List<List<Integer>> allIntervals = new ArrayList<>();
        int counter1 = 0;
        int counter2 = 0;
        while (counter1 < interval1.size() && counter2 < interval2.size()) {
            if (interval1.get(counter1).get(0) < interval2.get(counter2).get(0)) {
                allIntervals.add(interval1.get(counter1));
                counter1++;
            } else {
                allIntervals.add(interval2.get(counter2));
                counter2++;
            }
        }
        while (counter1 < interval1.size()) {
            allIntervals.add(interval1.get(counter1));
            counter1++;
        }
        while (counter2 < interval2.size()) {
            allIntervals.add(interval2.get(counter2));
            counter2++;
        }
        return allIntervals;
    }

    private static List<Integer> getBounds(StringMeeting dailyBounds1, StringMeeting dailyBounds2) {
        List<Integer> bounds = new ArrayList<>();
        List<Integer> boundInterval1 = getInterval(dailyBounds1);
        List<Integer> boundInterval2 = getInterval(dailyBounds2);
        bounds.add(Math.max(boundInterval1.get(0), boundInterval2.get(0)));
        bounds.add(Math.min(boundInterval1.get(1), boundInterval2.get(1)));
        return bounds;
    }

    private static List<List<Integer>> prepareIntervals(List<StringMeeting> calendar) {
        List<List<Integer>> intervals = new ArrayList<>();
        for (StringMeeting meeting : calendar) {
            List<Integer> interval = getInterval(meeting);
            intervals.add(interval);
        }
        return intervals;
    }

    private static List<Integer> getInterval(StringMeeting meeting) {
        String startTime = meeting.start;
        String endTime = meeting.end;

        Integer startHours = Integer.valueOf(startTime.split(":")[0]);
        Integer startMinutes = Integer.valueOf(startTime.split(":")[1]);

        Integer endHours = Integer.valueOf(endTime.split(":")[0]);
        Integer endMinutes = Integer.valueOf(endTime.split(":")[1]);

        List<Integer> interval = new ArrayList<>();
        Integer start = startHours * 60 + startMinutes;
        Integer end = endHours * 60 + endMinutes;
        interval.add(start);
        interval.add(end);
        return interval;
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
