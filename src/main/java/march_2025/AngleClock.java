package march_2025;

public class AngleClock {

    public double angleClock(int hour, int minutes) {
        double minAngle = (double) (360 * minutes) / 60;
        double hourAngle = (double) (360 * (60 * hour + minutes)) / (12 * 60);
        double angle = Math.abs(hourAngle - minAngle);
        return Math.min(angle, 360 - angle);
    }


}
