package july_2025;

public class RotateArray {

    public static void main(String[] args) {
//        int[] nums = {1,2,3,4,5,6,7};
//        int k = 3;

        int[] nums = {-1,-100,3,99};
        int k = 2;

        RotateArray rotateArray = new RotateArray();
        rotateArray.rotate(nums, k);
    }

    // O(n) time | O(1) space
    public void rotate(int[] nums, int k) {
        int l = 0;
        int r = nums.length - 1;
        k = k % nums.length;
        rotate(nums, l, r);

        l = 0;
        r = k - 1;
        rotate(nums, l, r);

        l = k;
        r = nums.length - 1;
        rotate(nums, l, r);
    }

    private static void rotate(int[] nums, int l, int r) {
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }

}
