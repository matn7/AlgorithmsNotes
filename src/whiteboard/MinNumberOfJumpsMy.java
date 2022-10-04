package whiteboard;

public class MinNumberOfJumpsMy {

    // O(n) time | O(1) space
    public static int minNumberOfJumps(int[] array) {
        // Write your code here.
        if (array.length == 1) {
            return 0;
        }
        int jumps = 0;
        int steps = array[0];
        int maxReach = array[0];

        for (int i = 1; i < array.length; i++) {
            maxReach = Math.max(maxReach, i + array[i]);
            steps--;
            if (steps == 0) {
                jumps++;
                steps = maxReach - i;
            }
        }

        return jumps + 1;
    }

}
