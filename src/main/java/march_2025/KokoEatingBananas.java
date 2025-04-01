package march_2025;

public class KokoEatingBananas {

    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int h = 8;

        KokoEatingBananas kokoEatingBananas = new KokoEatingBananas();
        int result = kokoEatingBananas.minEatingSpeed(piles, h);
        System.out.println(result);
    }

    public int minEatingSpeed(int[] piles, int h) {
        int R = 0;
        for (int pile : piles) {
            R = Math.max(pile, R);
        }
        int L = 1;
        int minSpeed = Integer.MAX_VALUE;
        while (L <= R) {
            int speed = (L + R) / 2; // (L + (R - L) / 2)
            int time = 0;

            for (int pile : piles) {
                time += Math.ceil(1.0 * pile / speed);
            }

            if (time <= h) {
                minSpeed = Math.min(minSpeed, speed);
                R = speed - 1;
            } else {
                L = speed + 1;
            }
        }
        return minSpeed == Integer.MAX_VALUE ? -1 : minSpeed;
    }

}
