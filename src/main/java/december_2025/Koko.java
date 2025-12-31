package december_2025;

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
        int result = koko.minEatingSpeed(piles, h);
        System.out.println(result);
    }

    // O(nlog(m)) time | O(1) space
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = 0;
        for (int pile : piles) {
            maxPile = Math.max(maxPile, pile);
        }
        int res = maxPile;
        int l = 1;
        int r = maxPile;

        // eating speed
        // 1 2 3 4 5 6 7 8 9 10 11
        // l         m           r
        while (l <= r) {
            int eatPerHour = (l + r) / 2;
            long currTime = 0;
            for (int pile : piles) {
                currTime += (long) Math.ceil((double) pile / eatPerHour);
            }
            if (currTime <= h) {
                res = Math.min(res, eatPerHour);
                // try eat slower
                r = eatPerHour - 1;
            } else {
                // must eat faster
                l = eatPerHour + 1;
            }
        }

        return res;
    }

}
