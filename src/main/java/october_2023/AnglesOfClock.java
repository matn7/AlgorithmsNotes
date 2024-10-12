package october_2023;

public class AnglesOfClock {

    public static void main(String[] args) {
        int h = 3;
        int m = 15;

        double result = anglesOfClock(h, m);
        System.out.println(result);
    }

    // O(1) time | O(1) space
    public static double anglesOfClock(int h, int m) {
        double hourAngle = (360 / 12.0 * 60.0) * (h * 60 + m);
        double minutesAngle = (360 / 60.0) * m;
        double angle = Math.abs(hourAngle - minutesAngle);
        return Math.min(angle, 360 - angle);
    }
}
