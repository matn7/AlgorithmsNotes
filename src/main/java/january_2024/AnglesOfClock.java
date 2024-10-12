package january_2024;

public class AnglesOfClock {

    public static void main(String[] args) {
        System.out.println(anglesOfClock(3, 15));
    }

    // O(1) time | O(1) space
    public static double anglesOfClock(int h, int m) {
        double hourAngle = (360/(12 * 60.0))*(h * 60 + m);
        double minuteAngle = (360*m/60.0);

        return Math.min(Math.abs(hourAngle - minuteAngle), 360 - Math.abs(hourAngle - minuteAngle));
        // s = v*t
        //
    }

}
