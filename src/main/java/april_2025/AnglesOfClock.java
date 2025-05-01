package april_2025;


public class AnglesOfClock {

    public static void main(String[] args) {
        int hour = 12;
        int minutes = 30;

        AnglesOfClock anglesOfClock = new AnglesOfClock();
        double result = anglesOfClock.angleClock(hour, minutes);
        System.out.println(result);
    }

    public double angleClock(int hour, int minutes) {
        double hourAngle = (360 / (12 * 60.0)) * (hour * 60 + minutes);
        double minutesAngle = (360 / 60.0) * minutes;

        double angle = Math.abs(hourAngle - minutesAngle);
        return Math.min(angle, 360 - angle);
    }

}
