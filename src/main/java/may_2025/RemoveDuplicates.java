package may_2025;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicates {

    public static void main(String[] args) {
//        int[] nums = {1, 1, 1, 2, 2, 3};
        int[] nums = {0,0,1,1,1,1,2,3,3};
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int result = removeDuplicates.removeDuplicates(nums);
        System.out.println(result);
    }

    public int removeDuplicates(int[] nums) {
        int pos = 0;
        int n = nums[0];
        int c = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (n != num) {
                c = 0;
                n = num;
            }
            c++;
            if (c <= 2) {
                nums[pos] = num;
                pos++;
            }
        }
        return pos;
    }

}
