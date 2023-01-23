package coderpro;

import java.util.Arrays;

public class DistributeBonuses {

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 3, 1};

        DistributeBonuses distributeBonuses = new DistributeBonuses();
        distributeBonuses.getBonuses(input);
    }

    // O(n) time | O(n) space
    public int[] getBonuses(int[] performances) {
        int count = performances.length;
        int[] bonuses = new int[performances.length];
        Arrays.fill(bonuses, 1);

        for (int i = 1; i < count; i++) {
            if (performances[i - 1] < performances[i]) {
                bonuses[i] = bonuses[i - 1] + 1;
            }
        }

        for (int i = performances.length - 2; i >= 0; i--) {
            if (performances[i + 1] < performances[i]) {
                bonuses[i] = Math.max(bonuses[i], bonuses[i + 1] + 1);
            }
        }

        return bonuses;
    }

    // O(n) time | O(n) space
    public int[] distributeBonuses(int[] input) {
        int[] bonuses = new int[input.length];
        Arrays.fill(bonuses, 1);

        // *
        // 1, 2, 3, 4, 3, 1
        //------------------
        // 1, 2, 3, 4, 2, 1
        for (int i = 1; i < input.length; i++) {
            if (input[i] > input[i - 1]) {
                bonuses[i] = bonuses[i - 1] + 1;
            }
        }

        for (int i = input.length - 2; i >= 0; i--) {
            if (input[i] > input[i + 1]) {
                bonuses[i] = Math.max(bonuses[i], bonuses[i + 1] + 1);
            }
        }
        return bonuses;
    }

}
