package august_2025;

import java.util.Arrays;

public class ShipCapacity {

    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;

        ShipCapacity shipCapacity = new ShipCapacity();
        int result = shipCapacity.shipWithinDays(weights, days);
        System.out.println(result);
    }

    public int shipWithinDays(int[] weights, int days) {
        Arrays.sort(weights);
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int w : weights) {
            sum += w;
            min = Math.min(min, w);
        }
        int max = sum;
        int res = 0;
        while (min <= max) {
            int weight = min + (max - min) / 2;
            int capacity = weight * days;
            if (capacity >= sum) {
                res = weight;
                max = weight - 1;
            } else {
                min = weight + 1;
            }
        }

        return res;
    }

}
