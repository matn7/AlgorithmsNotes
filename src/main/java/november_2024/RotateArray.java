package november_2024;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RotateArray {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        RotateArray rotateArray = new RotateArray();
        rotateArray.rotate(nums, k);

        System.out.println();
    }

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }

        l = 0;
        r = k - 1;
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }

        l = k;
        r = nums.length - 1;
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }

    public void rotate3(int[] nums, int k) {
        int[] newNums = new int[nums.length];
        k = k % nums.length;
        for (int i = 0; i < nums.length; i++) {
            newNums[(i + k) % nums.length] = nums[i];
        }
        System.arraycopy(newNums, 0, nums, 0, nums.length);
    }

    public void rotate2(int[] nums, int k) {
        List<Element> index = new ArrayList<>();
        k = k % nums.length;
        for (int i = 0; i < nums.length; i++) {
            index.add(new Element((i + k) % nums.length, nums[i]));
        }
        for (Element elem : index) {
            nums[elem.index] = elem.val;
        }
    }

    static class Element {
        int index;
        int val;

        public Element(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }

}
