package leetcode;

import javax.swing.table.TableStringConverter;
import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {

    public static void main(String[] args) {
        //
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> output = new ArrayList<>();
        for (int n : nums) {
            int value = Math.abs(n) - 1;
            if (nums[value] < 0) {
                output.add(Math.abs(n));
            } else {
                nums[value] = nums[value] * -1;
            }
        }
        return output;
    }
}
