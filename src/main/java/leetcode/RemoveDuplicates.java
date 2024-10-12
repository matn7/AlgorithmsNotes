package leetcode;

public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        int p = 0;
        int currPtr = 0;

        while (currPtr < nums.length) {
            int number = nums[currPtr];
            while (currPtr < nums.length && nums[currPtr] == number) {
                currPtr++;
            }
            nums[p] = number;
            p++;
        }
        return p;
    }

}
