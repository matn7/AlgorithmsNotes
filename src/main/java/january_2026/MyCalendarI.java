package january_2026;

import java.util.TreeMap;

public class MyCalendarI {

    public static void main(String[] args) {
        MyCalendarI myCalendarI = new MyCalendarI();
        System.out.println(myCalendarI.book(10, 20));
        System.out.println(myCalendarI.book(15, 25));
        System.out.println(myCalendarI.book(20, 30));
    }

    // O(log(n)) time | O(n) space
    private TreeMap<Integer, Integer> calendar;

    public MyCalendarI() {
        calendar = new TreeMap<>();
    }

    public boolean book(int startTime, int endTime) {

        Integer prev = calendar.floorKey(startTime);
        if (prev != null && calendar.get(prev) > startTime) { // 20 > 15 | 20 > 30
            return false;
        }

        Integer next = calendar.ceilingKey(startTime);
        if (next != null && next < endTime) {
            return false;
        }

        calendar.put(startTime, endTime);
        return true;
    }


}
