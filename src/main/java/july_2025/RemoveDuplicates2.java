package july_2025;

public class RemoveDuplicates2 {

    public static void main(String[] args) {
//        int[] nums = {0,0,1,1,1,1,2,3,3};
        int[] nums = {1,1,1,2,2,3};
        RemoveDuplicates2 removeDuplicates2 = new RemoveDuplicates2();
        int result = removeDuplicates2.removeDuplicates(nums);
        System.out.println(result);
    }

    // Intuition:
    // - counter of occurrences
    // - keep updating position
    // Approach:
    // - pos idx
    // - curr val - keep updating elems with curr up to min(pos + 2, pos + counter)
    // Complexity:
    // O(n) time | O(1) space
    // Code:

    public int removeDuplicates(int[] nums) {
        int pos = 0;
        int idx = 0;
        while (idx < nums.length) {
            int curr = nums[idx];
            int count = 0;
            while (idx < nums.length && nums[idx] == curr) {
                count++;
                idx++;
            }
            int nextPos = Math.min(pos + 2, pos + count);
            for (int i = pos; i < nextPos; i++) {
                nums[i] = curr;
            }
            pos = nextPos;
        }
        return pos;
    }

}
