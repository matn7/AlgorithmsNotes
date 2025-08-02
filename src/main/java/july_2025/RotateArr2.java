package july_2025;

public class RotateArr2 {

    public static void main(String[] args) {
//        int[] nums = {1,2,3,4,5,6,7};
//        int k = 3;

        int[] nums = {-1,-100,3,99};
        int k = -2;

        RotateArr2 rotateArr2 = new RotateArr2();
        rotateArr2.rotate(nums, k);


        System.out.println();
    }

    // O(n) time | O(1) space
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) {
            return;
        }
        k = k % n;
        if (k < 0) {
            k = n + k;
        }

        int l = 0;
        int r = nums.length - 1;

        reverse(nums, l, r);
        l = 0;
        r = k - 1;
        reverse(nums, l, r);

        l = k;
        r = nums.length - 1;
        reverse(nums, l, r);
    }

    private void reverse(int[] nums, int l, int r) {
        while (l <= r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }

}
