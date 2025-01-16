package november_2024;

public class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length == 1 && flowerbed[0] == 0) {
            n--;
            return n == 0;
        }
        for (int i = 0; i < flowerbed.length; i++) {
            if (n == 0) {
                return true;
            }
            if (flowerbed[i] != 1) {
                if (i == 0) {
                    if (i < flowerbed.length - 1 && flowerbed[i + 1] != 1) {
                        flowerbed[i] = 1;
                        n--;
                    }
                } else if (i == flowerbed.length - 1) {
                    if (flowerbed[i - 1] != 1) {
                        flowerbed[i] = 1;
                        n--;
                    }
                } else {
                    if (flowerbed[i - 1] != 1 && flowerbed[i + 1] != 1) {
                        flowerbed[i] = 1;
                        n--;
                    }
                }
            }
        }
        return n == 0;
    }

}
