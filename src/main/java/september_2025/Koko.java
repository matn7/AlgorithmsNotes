package september_2025;

public class Koko {

    public static void main(String[] args) {
//        int[] piles = {3,6,7,11};
//        int h = 8;

//        int[] piles = {30,11,23,4,20};
//        int h = 5;

//        int[] piles = {30,11,23,4,20};
//        int h = 6;

        int[] piles = {805306368,805306368,805306368};
        int h = 1000000000;

        Koko koko = new Koko();
        int speed = koko.minEatingSpeed(piles, h);
        System.out.println(speed);
    }

    // O(nlog(m)) time | O(1) space
    public int minEatingSpeed(int[] piles, int h) {
        int r = 0;
        for (int pile : piles) {
            r = Math.max(r, pile);
        }
        int l = 1;
        int k = r; // speed = num eaten / hour
        // O(log(n)) time
        while (l <= r) {
            int m = (l + r) / 2;
            double time = 0;
            // O(n) time
            for (int pile : piles) {
                time += Math.ceil((double) pile / m);
            }
            if (time > h) {
                // wasn't able to eat all within time, must eat faster
                l = m + 1;
            } else {
                // was able to eat all, may eat even slower
                k = Math.min(k, m);
                r = m - 1;
            }
        }
        return k;
    }

}
