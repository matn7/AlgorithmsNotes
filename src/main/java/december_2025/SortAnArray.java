package december_2025;

public class SortAnArray {

    public static void main(String[] args) {
        int[] nums = {5,1,1,2,0,0};

        SortAnArray sortArray = new SortAnArray();
        int[] result = sortArray.sortArray(nums);
        System.out.println(result);
    }

    // O(nlog(n)) time | O(n) space
    public int[] sortArray(int[] nums) {
        // merge sort
        if (nums.length <= 1) {
            return nums;
        }
        int half = nums.length / 2;
        int[] leftHalf = new int[half];
        for (int i = 0; i < half; i++) {
            leftHalf[i] = nums[i];
        }
        int[] rightHalf = new int[nums.length - half];
        int idx = 0;
        for (int i = half; i < nums.length; i++) {
            rightHalf[idx] = nums[i];
            idx++;
        }

        return merge(sortArray(leftHalf), sortArray(rightHalf));
    }

    private int[] merge(int[] left, int[] right) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] res = new int[left.length + right.length];
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                res[k] = left[i];
                i++;
            } else {
                res[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < left.length) {
            res[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            res[k] = right[j];
            j++;
            k++;
        }
        return res;
    }

}
