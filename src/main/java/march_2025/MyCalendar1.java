package march_2025;

import java.util.ArrayList;
import java.util.List;

public class MyCalendar1 {

    List<int[]> array;

    public MyCalendar1() {
        array = new ArrayList<>();
    }

    public boolean book(int startTime, int endTime) {
        for (int[] element : array) {
            if (startTime < element[1] && element[0] < endTime) {
                return false;
            }
        }
        array.add(new int[] {startTime, endTime});
        return true;
    }


}
