package july_2024;

public class MinNumberOfJumps {

    public static void main(String[] args) {
        int[] nums = {3, 2, 5, 1, 1, 9, 3, 4};

        int result = minNumberOfJumps(nums);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public static int minNumberOfJumps(int[] array) {
        if (array.length == 1) {
            return 0;
        }
        //  0  1  2  3  4  5  6  7
        // [3, 2, 5, 1, 1, 9, 3, 4]
        //                       *
        // jumps = 1
        int jumps = 0;
        int maxReach = array[0]; // 7
        int steps = array[0]; // 1
        for (int i = 1; i < array.length - 1; i++) {
            maxReach = Math.max(maxReach, i + array[i]); // max(14, 6 + 3)
            steps -= 1;
            if (steps == 0) {
                jumps += 1;
                steps = maxReach - i;
            }
        }
        return jumps + 1;
    }

}
