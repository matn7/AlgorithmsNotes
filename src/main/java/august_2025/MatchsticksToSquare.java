package august_2025;

import java.util.Arrays;

public class MatchsticksToSquare {

    public static void main(String[] args) {
        int[] matchsticks = {1, 1, 2, 2, 2};

        MatchsticksToSquare matchsticksToSquare = new MatchsticksToSquare();
        boolean result = matchsticksToSquare.makesquare(matchsticks);
        System.out.println(result);
    }

    // O(4^n) time | O(n) space
    public boolean makesquare(int[] matchsticks) {
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        int sum = 0;
        for (int num : matchsticks) {
            sum += num;
        }
        if (sum % 4 != 0) {
            return false;
        }
        int length = sum / 4;
        int[] sides = new int[4];

        return backtrack(matchsticks, 0, sides, length);
    }

    private boolean backtrack(int[] matchsticks, int i, int[] sides, int length) {
        if (i == matchsticks.length) {
            return true;
        }

        for (int j = 0; j < 4; j++) {
            if (sides[j] + matchsticks[i] <= length) {
                sides[j] += matchsticks[i];
                if (backtrack(matchsticks, i + 1, sides, length)) {
                    return true;
                }
                sides[j] -= matchsticks[i];
            }
        }
        return false;
    }

    private void reverse(int[] matchsticks) {
        int i = 0;
        int j = matchsticks.length - 1;
        while (i <= j) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
            i++;
            j--;
        }
    }


}
