package july_2025;

public class FindDuplicateNum {

    // Intuition:
    // - brute force - store duplicate in sets
    // - no extra space, take advantage of content of question
    // - [1, n] range, of numbers so probably match index (no out of bounds)
    // - slow and fast pointer on array
    // Approach:
    //  - slow = 0, fast = 0
    // Complexity:
    // - O(n) time | O(1) space
    // Code:

    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                break;
            }
        }
        int slow2 = 0;
        while (slow2 != slow) {
            slow = nums[slow];
            slow2 = nums[slow2];
        }
        return slow;
    }

}
