package august_2024;

public class AnglesOfClock {

    public static void main(String[] args) {
        int m = 15;
        int h = 3;

        double result = anglesOfClock(h, m);
        System.out.println(result);
    }

    // O(1) time | O(1) space
    public static double anglesOfClock(int h, int m) {
        double minuteAngle = (360 * m) / 60.0;
        double hourAngle = (360 * (60 * h + m)) / (12 * 60.0);
        double angle = Math.abs(hourAngle - minuteAngle);
        return Math.min(angle, 360.0 - angle);
    }

}
