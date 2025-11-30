package november_2025;

public class FindDuplicateNumber {

    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};

        FindDuplicateNumber findDuplicateNumber = new FindDuplicateNumber();
        int result = findDuplicateNumber.findDuplicate(nums);
        System.out.println(result);
    }

    // O(n) time | O(1) space
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
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

}
