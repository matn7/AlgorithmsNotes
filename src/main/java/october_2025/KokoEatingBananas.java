package october_2025;

public class KokoEatingBananas {

    public static void main(String[] args) {
//        int[] piles = {3, 6, 7, 11};
//        int h = 8;
//        int[] piles = {30,11,23,4,20};
//        int h = 5;

//        int[] piles = {30,11,23,4,20};
//        int h = 6;

        int[] piles = {805306368,805306368,805306368};
        int h = 1000000000;

        KokoEatingBananas kokoEatingBananas = new KokoEatingBananas();
        int result = kokoEatingBananas.minEatingSpeed(piles, h);
        System.out.println(result);
    }

    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 1;
        for (int pile : piles) {
            r = Math.max(pile, r);
        }
        int speed = r;

        // O(m * log(n)) time | O(1) space
        // n - [l, r] -> (1, max(nums))
        // m - num elems in piles
        while (l <= r) {
            int currSpeed = l + (r - l) / 2;
            int currTime = 0;
            for (int pile : piles) {
                currTime += Math.ceil(1.0 * pile / currSpeed);
            }
            if (currTime <= h) {
                speed = Math.min(speed, currSpeed);
                r = currSpeed - 1;
            } else {
                l = currSpeed + 1;
            }
        }
        return speed;
    }


}
