package january_2025;

public class MinEatingSpeed {

    public static void main(String[] args) {
//        int[] piles = {3, 6, 7, 11};
//        int h = 8;

//        int[] piles = {30, 11, 23, 4, 20};
//        int h = 5;

//        int[] piles = {312884470};
//        int h = 312884469;

        int[] piles = {805306368,805306368,805306368};
        int h = 1000000000;

        MinEatingSpeed minEatingSpeed = new MinEatingSpeed();
        int result = minEatingSpeed.minEatingSpeed(piles, h);
        System.out.println(result);
    }

    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int p : piles) {
            max = Math.max(max, p);
        }
        int min = 1;
        int speed = max;
        while (min <= max) {
            int m = (min + max) / 2; // 7
            int time = 0;
            for (int pile : piles) {
                time += Math.ceil(1.0 * pile / m);
            }
            if (time <= h) { // 5h < 8h
                speed = Math.min(speed, m);
                max = m - 1;
            } else {
                min = m + 1;
            }
        }
        return speed;
    }

}
