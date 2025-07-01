package june_2025;

public class MinEatingSpeed {

    public static void main(String[] args) {
//        int[] piles = {3, 6, 7, 11};
//        int h = 8;

//        int[] piles = {30,11,23,4,20};
//        int h = 5;

//        int[] piles = {30,11,23,4,20};
//        int h = 6;

        int[] piles = {805306368,805306368,805306368};
        int h = 1000000000;
        MinEatingSpeed minEatingSpeed = new MinEatingSpeed();
        int result = minEatingSpeed.minEatingSpeed(piles, h);
        System.out.println(result);
    }

    // O(log(n)) time | O(1) space
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        int L = 1;
        int R = max;
        int minSpeed = max;
        while (L <= R) {
            int currSpeed = L + (R - L) / 2;
            int eatHours = 0;
            for (int pile : piles) {
                eatHours += Math.ceil(1.0 * pile / currSpeed);
            }
            if (eatHours < h) {
                minSpeed = Math.min(minSpeed, currSpeed);
                R = currSpeed - 1;
            } else {
                L = currSpeed + 1;
            }
        }
        return minSpeed;
    }

}
