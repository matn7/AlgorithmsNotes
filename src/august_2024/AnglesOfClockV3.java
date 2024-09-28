package august_2024;

public class AnglesOfClockV3 {

    public static void main(String[] args) {
        int m = 15;
        int h = 3;

        double result = anglesOfClock(m, h);
        System.out.println(result);
    }

    // O(1) time | O(1) space
    public static double anglesOfClock(int m, int h) {
        double minutesAngles = 360 * m / 60.0;
        double hourAngles = 360 * (h * 60 + m) / (12 * 60.0);
        double angle = Math.abs(minutesAngles - hourAngles);
        return Math.min(angle, 360 - angle);
    }

}
