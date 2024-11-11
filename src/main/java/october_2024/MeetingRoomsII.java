package october_2024;

import java.util.*;

public class MeetingRoomsII {

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(0, 30));
        intervals.add(new Interval(5, 10));
        intervals.add(new Interval(15, 20));


    }

    // O(nlog(n)) time | O(n) space
    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here
        intervals.sort(Comparator.comparing(a -> a.start));
        PriorityQueue<Element> queue = new PriorityQueue<>();

        for (Interval interval : intervals) {
            if (queue.isEmpty()) {
                queue.add(new Element(interval));
            } else {
                Element currentMeeting = queue.peek(); // [0, 30]
                // [5, 10]
                if (currentMeeting.interval.end <= interval.start) {
                    queue.poll();
                }
                queue.add(new Element(interval));
            }
        }
        return queue.size();
    }

    static class Element implements Comparable<Element> {
        Interval interval;

        public Element(Interval interval) {
            this.interval = interval;
        }

        @Override
        public int compareTo(Element o) {
            return interval.end - o.interval.end;
        }
    }

}
