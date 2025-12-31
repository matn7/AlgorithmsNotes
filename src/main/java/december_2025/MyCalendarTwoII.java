package december_2025;

import java.util.ArrayList;
import java.util.List;

public class MyCalendarTwoII {

    List<int[]> bookings;
    List<int[]> overlap;

    public MyCalendarTwoII() {
        bookings = new ArrayList<>();
        overlap = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] o : overlap) {
            if (end > o[0] && start < o[1]) {
                return false;
            }
        }

        for (int[] b : bookings) {
            if (start < b[1] && end > b[0]) {
                overlap.add(new int[] {Math.max(b[0], start), Math.min(b[1], end)});
            }

        }

        bookings.add(new int[] {start, end});
        return true;
    }

}
