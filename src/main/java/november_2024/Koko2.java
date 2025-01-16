package november_2024;

import java.math.BigInteger;

public class Koko2 {

    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int h = 8;

        Koko2 koko2 = new Koko2();
        int result = koko2.minEatingSpeed(piles, h);
        System.out.println(result);
    }

    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int p : piles) {
            max = Math.max(max, p);
        }
        int l = 1;
        int r = max;
        int speed = max;
        while (l <= r) {
            int m = (l + r) / 2; // 6
            int time = 0;
            for (int p : piles) {
                time += Math.ceil(1.0 * p / m);
            }
            // time = 6 (took 6 hours to eat - 2 h buffer)
            if (time <= h) {
                // can eat less
                r = m - 1;
                speed = Math.min(speed, m);
            } else {
                // must eat more
                l = m + 1;
            }
        }
        return speed;
    }

}
