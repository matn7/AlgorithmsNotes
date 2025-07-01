package june_2025;

public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};

        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int result = removeDuplicates.removeDuplicates(nums);
        System.out.println(result);
    }


    // O(n) time | O(1) space
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 0;

        while (j < nums.length) {
            nums[i] = nums[j];
            while (j < nums.length && nums[i] == nums[j]) {
                j++;
            }
            i++;
        }
        return i;
    }

}
