package december_2025;

import java.util.ArrayList;
import java.util.List;

public class MyCalendarTwo {

    private List<int[]> bookings;
    private List<int[]> overlaps;

    public MyCalendarTwo() {
        bookings = new ArrayList<>();
        overlaps = new ArrayList<>();
    }

    public boolean book(int start, int end) {

        // 1. Sprawdzenie potrójnej rezerwacji
        for (int[] o : overlaps) {
            if (start < o[1] && end > o[0]) {
                return false;
            }
        }

        // 2. Dodanie nowych podwójnych rezerwacji
        for (int[] b : bookings) {
            if (start < b[1] && end > b[0]) {
                overlaps.add(new int[]{
                        Math.max(start, b[0]),
                        Math.min(end, b[1])
                });
            }
        }

        // 3. Dodanie rezerwacji
        bookings.add(new int[]{start, end});
        return true;
    }

}
