package november_2025;

public class Koko {

    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        int h = 8;

//        int[] piles = {805306368,805306368,805306368};
//        int h = 1000000000;

        Koko koko = new Koko();
        int result = koko.minEatingSpeed(piles, h);
        System.out.println(result);
    }

    // O(n * log(m)) time | O(1) space
    public int minEatingSpeed(int[] piles, int h) {
        int r = 0;
        for (int p : piles) {
            r = Math.max(r, p);
        }
        int l = 1;
        int minSpeed = r;

        while (l <= r) {
            int speed = l + (r - l) / 2;
            long time = 0;
            for (int p : piles) {
                time += (int) Math.ceil(1.0 * p / speed);
            }
            if (time <= h) {
                // Koko was able to eat app piles
                minSpeed = Math.min(minSpeed, speed);
                // can eat slower
                r = speed - 1;
            } else {
                // must eat faster
                l = speed + 1;
            }
        }
        return minSpeed;
    }
}
