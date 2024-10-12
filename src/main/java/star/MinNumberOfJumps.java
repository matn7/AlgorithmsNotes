package star;

import java.util.Arrays;

public class MinNumberOfJumps {

    public static void main(String[] args) {
        int[] array = {3, 4, 2, 1, 2, 3, 7, 1, 1, 1, 3};

        MinNumberOfJumps minNumberOfJumps = new MinNumberOfJumps();
        minNumberOfJumps.minNUmberOfJumps(array);

    }

    // O(n^2) time | O(n) space
    public int minNUmberOfJumps(int[] array) {
        int[] jumps = new int[array.length];
        Arrays.fill(jumps, Integer.MAX_VALUE);
        jumps[0] = 0;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[j] + j >= i) {
                    jumps[i] = Math.min(jumps[j] + 1, jumps[i]);
                }
            }
        }
        return jumps[jumps.length - 1];
    }

}
