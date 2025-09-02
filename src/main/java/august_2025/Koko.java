package august_2025;

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

    // O(log(n) * n) time | O(1) space
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        int l = 1;
        int r = max;
        int res = max;

        while (l <= r) {
            int eatSpeed = l + (r - l) / 2;
            int time = 0;
            for (int pile : piles) {
                time += Math.ceil(1.0 * pile / eatSpeed);
            }
            if (time <= h) {
                res = Math.min(res, eatSpeed);
                r = eatSpeed - 1;
            } else {
                l = eatSpeed + 1;
            }
        }

        return res;
    }


}
