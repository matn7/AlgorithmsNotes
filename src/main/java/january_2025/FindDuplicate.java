package january_2025;

public class FindDuplicate {

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        FindDuplicate findDuplicate = new FindDuplicate();
        int duplicate = findDuplicate.findDuplicate(nums);
        System.out.println(duplicate);
    }

    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
            if (slow == fast) {
                return slow;
            }
        }
        return slow;
    }

}
