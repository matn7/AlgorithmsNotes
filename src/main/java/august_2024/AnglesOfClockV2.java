package august_2024;

public class AnglesOfClockV2 {

    public static void main(String[] args) {
        int m = 15;
        int h = 3;

        double result = anglesOfClock(m, h);
        System.out.println(result);
    }

    // O(1) time | O(1) space
    public static double anglesOfClock(int m, int h) {
        double minutesAngle = 360 * m / 60.0;
        double hourAngle = 360 *(60 * h + m) / (12 * 60.0);

        double result = Math.abs(minutesAngle - hourAngle);
        return Math.min(result, 360 - result);
    }

}
