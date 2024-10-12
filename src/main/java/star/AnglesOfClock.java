package star;

public class AnglesOfClock {

    public static void main(String[] args) {
        AnglesOfClock anglesOfClock = new AnglesOfClock();
        double result = anglesOfClock.calcAngle(3, 15);
        System.out.println(result);
    }

    // O(1) time | O(1) space
    public double calcAngle(int h, int m) {
        double hours_angles = (360 / (12 * 60.0)) * (h * 60 + m);
        double minutes_angles = (360 / 60.0) * m;
        double angles = Math.abs(hours_angles - minutes_angles);
        return Math.min(angles, 360 - angles);
    }


}
