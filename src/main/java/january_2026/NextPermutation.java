package january_2026;

public class NextPermutation {

    public static void main(String[] args) {
        // int[] nums = {1, 2, 3, 5, 4, 4, 1};
//        int[] nums = {1, 2, 3};
//        int[] nums = {3, 2, 1};
        int[] nums = {1,1,5};

        NextPermutation nextPermutation = new NextPermutation();

        nextPermutation.nextPermutation(nums);

        System.out.println();
    }

    // O(n) time | O(1) space
    public void nextPermutation(int[] nums) {
        int right = nums.length - 2;
        int pivot = -1;
        while (right >= 0) {
            if (nums[right] < nums[right + 1]) {
                pivot = right;
                break;
            }
            right--;
        }

        if (pivot == -1) {
            reverse(0, nums.length - 1, nums);
        } else {
            // find first greater then pivot
            right = nums.length - 1;
            while (right > pivot) {
                if (nums[right] > nums[pivot]) {
                    break;
                }
                right--;
            }
            swap(pivot, right, nums);
            reverse(pivot + 1, nums.length - 1, nums);
        }

    }

    private void reverse(int start, int end, int[] nums) {
        while (start <= end) {
            swap(start, end, nums);
            start++;
            end--;
        }
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
