package april_2025;

public class SortColorsII {

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};

        SortColorsII sortColorsII = new SortColorsII();
        sortColorsII.sortColors(nums);

        System.out.println();
    }

    // O(n) time | O(1) space
    public void sortColors(int[] nums) {
        int L = 0;
        int R = nums.length - 1;
        int I = 0;

        while (I <= R) {
            if (nums[I] == 0) {
                swap(nums, I, L);
                I++;
                L++;
            } else if (nums[I] == 2) {
                swap(nums, I, R);
                R--;
            } else {
                I++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
