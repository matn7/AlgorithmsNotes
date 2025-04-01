package january_2025;

public class KokoEatingBananas {

    public static void main(String[] args) {
//        int[] piles = {3, 6, 7, 11};
//        int h = 8;

//        int[] piles = {30,11,23,4,20};
//        int h = 5;

//        int[] piles = {30,11,23,4,20};
//        int h = 6;

        int[] piles = {312884470};
        int h = 312884469;

        KokoEatingBananas kokoEatingBananas = new KokoEatingBananas();
        int result = kokoEatingBananas.minEatingSpeed(piles, h);
        System.out.println(result);
    }

    public int minEatingSpeed(int[] piles, int h) {
        int s = 1;
        int e = 0;
        for (int p : piles) {
            e = Math.max(e, p);
        }
        int min = e;

        while (s <= e) {
            int m = (s + e) / 2;
            int time = 0;
            for (int p : piles) {
                time += Math.ceil(1.0 * p / m);
            }
            if (time <= h) {
                min = m;
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return min;
    }

}
