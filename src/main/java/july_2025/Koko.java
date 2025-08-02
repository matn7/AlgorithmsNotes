package july_2025;

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

    // O(n * log(m)) time | O(1) space
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;
        for (int pile : piles) {
            r = Math.max(r, pile);
        }

        int result = r;

        while (l <= r) { // O(log(m))
            int m = (l + r) / 2; // can eat 6 in hour
            int time = 0;
            for (int pile : piles) { // O(n)
                time += Math.ceil(1.0 * pile / m);
            }
            if (time <= h) {
                // can eat all, we can check slower speed
                result = Math.min(r, m);
                r = m - 1;
            } else {
                // eat too slow, wasn't able to eat all
                l = m + 1;
            }
        }

        return result;
    }

}
