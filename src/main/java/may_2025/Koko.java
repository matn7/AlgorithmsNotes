package may_2025;

public class Koko {

    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        int h = 8;

        Koko koko = new Koko();
        int result = koko.minEatingSpeed(piles, h);
        System.out.println(result);
    }

    // O(n*log(m)) time | O(1) space
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        int l = 1;
        int r = max;
        int minSpeed = max;
        while (l <= r) { // log(m)
            int m = (l + r) / 2;
            int time = 0;
            for (int pile : piles) { // n
                time += Math.ceil(1.0 * pile / m);
            }
            if (time <= h) {
                minSpeed = Math.min(m, minSpeed);
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return minSpeed;
    }


}
