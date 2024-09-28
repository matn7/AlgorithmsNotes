package july_2024;

public class AnglesOfAClock {

    public static void main(String[] args) {
        int h = 3;
        int m = 15;

        double result = calcAngle(h, m);
        System.out.println(result);
    }

    // O(1) time | O(1) space
    public static double calcAngle(int h, int m) {
        double hourAngle = (360 / (12 * 60.0)) * (h * 60.0 + m);
        double minAngle = (360 / 60.0) * m;
        double angle = Math.abs(hourAngle - minAngle);
        return Math.min(angle, 360 - angle);
    }

}
