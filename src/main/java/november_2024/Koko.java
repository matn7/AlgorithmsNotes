package november_2024;

public class Koko {

    public static void main(String[] args) {
        Koko koko = new Koko();
//        int[] piles = {3, 6, 7, 11};
//        int h = 8;
        // [30,11,23,4,20], h = 6

        int[] piles = {30,11,23,4,20};
        int h = 6;
        int result = koko.minEatingSpeed(piles, h);
        System.out.println(result);
    }

    public int minEatingSpeed(int[] piles, int h) {

        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int pile : piles) {
            sum += pile;
            min = Math.min(min, pile);
            max = Math.max(max, pile);
        }

        if (piles.length == h) {
            return max;
        }

        int bananas = max;
        while (min <= max) {
            int mid = (min + max) / 2;
            int speed = (int) Math.ceil(1.0 * sum / mid); // 27/7 = 4 (took h hours to eat all)
            if (speed <= h) {
                // Koko can eat slower
                max = mid - 1;
                int count = 0;
                for (int p : piles) {
                    int val = p;
                    while (val > speed) {
                        count++;
                        val = val - speed;
                    }
                    count++;
                }
                if (count <= h) {
                    bananas = Math.min(bananas, speed);
                }
            } else {
                min = mid + 1;
            }

        }

        return bananas;

    }

}
