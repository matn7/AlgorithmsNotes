package october_2024;

public class KokoEatingBananas {

    public static void main(String[] args) {
//        int[] piles = {30,11,23,4,20};
//        int h = 5;

//        int[] piles = {312884470};
//        int h = 312884469;

        int[] piles = {3,6,7,11};
        int h = 18;

        KokoEatingBananas kokoEatingBananas = new KokoEatingBananas();
        int result = kokoEatingBananas.minEatingSpeed(piles, h);
        System.out.println(result);
    }

    // leetcode 875
    public int minEatingSpeed(int[] piles, int h) {
        int max = getMax(piles);
        return binarySearch(piles, h, max);
    }

    private static int binarySearch(int[] piles, int h, int max) {
        int left = 1;
        int right = max;
        int result = max;
        while (left <= right) {
            int k = (left + right) / 2;
            // how many times took for 7 bananas
            int hours = 0;
            for (int pile : piles) {
                hours += Math.ceil((double) pile / k); // Use double casting directly here
            }
            if (hours <= h) {
                // can eat less bananas
                right = k - 1;
                result = Math.min(result, k);
            } else {
                // must eat more
                left = k + 1;
            }
        }
        return result;
    }

    private int getMax(int[] piles) {
        int max = Integer.MIN_VALUE;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        return max;
    }


}
