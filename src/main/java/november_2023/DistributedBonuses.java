package november_2023;

import java.util.Arrays;

public class DistributedBonuses {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 3, 1};

        int[] result = bonuses(arr);
    }

    // O(n) time | O(n) space
    public static int[] bonuses(int[] arr) {
        int[] bonuses = new int[arr.length];
        Arrays.fill(bonuses, 1);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                bonuses[i] = bonuses[i - 1] + 1;
            }
        }

        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                bonuses[i] = Math.max(bonuses[i], bonuses[i + 1] + 1);
            }
        }

        return bonuses;
    }

}
