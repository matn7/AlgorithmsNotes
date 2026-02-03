package january_2026;

public class Koko {

    public static void main(String[] args) {
//        int[] piles = {3,6,7,11};
//        int h = 8;

//        int[] piles = {30,11,23,4,20};
//        int h = 5;

        int[] piles = {30,11,23,4,20};
        int h = 6;

        Koko koko = new Koko();
        int speed = koko.minEatingSpeed(piles, h);
        System.out.println(speed);
    }

    // O(n * log(m)) time | O(1) space
    // m - max in pile
    // n - num of piles
    public int minEatingSpeed(int[] piles, int h) {
        int R = 0;
        for (int pile : piles) {
            R = Math.max(R, pile);
        }
        int L = 1;
        int eatSpeed = R;
        while (L <= R) {
            int currSpeed = (L + R) / 2;
            long timeToEat = 0;
            for (int pile : piles) {
                timeToEat += (int) Math.ceil(1.0 * pile / currSpeed);
            }
            if (timeToEat <= h) {
                // koko was able to eat all within a time, save res try to eat slower
                eatSpeed = Math.min(eatSpeed, currSpeed);
                R = currSpeed - 1;
            } else {
                // must eat faster
                L = currSpeed + 1;
            }
        }
        return eatSpeed;
    }



}
