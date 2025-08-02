package july_2025;

import java.util.Map;

public class AngleClock {

    public static void main(String[] args) {
        int hour = 12;
        int minute = 30;

        AngleClock angleClock = new AngleClock();
        double result = angleClock.angleClock(hour, minute);
        System.out.println(result);
    }

    // O(1) time | O(1) space
    public double angleClock(int hour, int minutes) {
        double min_angle = (double) 360 * minutes / 60;
        double hour_angle = (double) 360 * (60 * hour + minutes) / (12 * 60);
        double angle = Math.abs(hour_angle - min_angle);
        return Math.min(angle, 360 - angle);
    }

}
