package november_2025;

public class NextLexicographicalSequence {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5, 4, 4, 1};

        NextLexicographicalSequence nextLexicographicalSequence = new NextLexicographicalSequence();
        nextLexicographicalSequence.nextPermutation(nums);
        System.out.println();
    }

    // O(n) time | O(n) space
    public void nextPermutation(int[] nums) {
        // breaks no increasing from right;
        int pivot = nums.length - 2;
        while (pivot >= 0) {
            if (nums[pivot] < nums[pivot + 1]) {
                break;
            }
            pivot--;
        }
        if (pivot == -1) {
            reverse(nums, 0);
            return;
        }
        int right = nums.length - 1;
        while (right >= 0 && nums[right] <= nums[pivot]) {
            right--;
        }
        swap(nums, pivot, right);
        reverse(nums, pivot + 1);
    }

    private void reverse(int[] nums, int l) {
        int r = nums.length - 1;
        while (l <= r) {
            swap(nums, l, r);
            l++;
            r--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
