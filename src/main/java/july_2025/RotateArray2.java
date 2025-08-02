package july_2025;

public class RotateArray2 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;

        RotateArray2 rotateArray2 = new RotateArray2();
        rotateArray2.rotate(nums, k);
        System.out.println();
    }

    // O(n) time | O(1) space
    public void rotate(int[] nums, int k) {
        k = k % nums.length;

        swap(nums, 0, nums.length - 1);

        swap(nums, 0, k - 1);

        swap(nums, k, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

}
