package november_2024;

public class CanPlaceFlowers2 {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int[] f = new int[flowerbed.length + 2];
        f[0] = 0;
        System.arraycopy(flowerbed, 0, f, 1, flowerbed.length);
        f[f.length - 1] = 0;

        for (int i = 1; i < f.length - 1; i++) {
            if (f[i - 1] == 0 && f[i] == 0 && f[i + 1] == 0) {
                f[i] = 1;
                n--;
            }
        }
        return n <= 0;
    }

}
