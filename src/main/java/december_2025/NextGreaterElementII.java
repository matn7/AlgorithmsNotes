package december_2025;

import java.util.ArrayDeque;
import java.util.Arrays;

public class NextGreaterElementII {

    public static void main(String[] args) {
//        int[] nums = {1,2,3,4,3};

//        int[] nums = {1,2,1};

        int[] nums = {9, 8, 7, 6, 5, 4, 3, 2, 1};

        NextGreaterElementII nextGreaterElementII = new NextGreaterElementII();
        int[] result = nextGreaterElementII.nextGreaterElements(nums);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int[] nextGreaterElements(int[] nums) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < 2 * nums.length; i++) {
            int idx = i % nums.length;
            int num = nums[idx];

            while (!stack.isEmpty() && num > nums[stack.getLast()]) {
                int pop = stack.removeLast();
                res[pop] = num;
            }
            stack.addLast(idx);
        }
        return res;
    }

}
