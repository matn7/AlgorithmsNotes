package coderpro;

public class AnglesOfClock {

    public static void main(String[] args) {

        AnglesOfClock anglesOfClock = new AnglesOfClock();
        double result = anglesOfClock.calcAngle(3, 15);
        System.out.println(result);

    }

    // O(1) time | O(1) space
    public double calcAngle(int h, int m) {
        double hour_angle = (360 / (12 * 60.0)) * (h * 60 + m);
        double min_angle = (360 / 60.0) * m;
        double angle = Math.abs(hour_angle - min_angle);
        return Math.min(angle, 360 - angle);
    }
    
}
