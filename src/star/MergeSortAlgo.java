package star;

public class MergeSortAlgo {

    public static void main(String[] args) {

        int[] nums = {12, 45, 6, 12, -90, 9087, 765, 234, 9, 0, 1, -12, -1, 87, 654};
        MergeSortAlgo mergeSortAlgo = new MergeSortAlgo();
        int[] ints = mergeSortAlgo.mergeSort(nums);
        System.out.println();

    }

    // O(nlog(n)) time | O(n) space
    public int[] mergeSort(int[] nums) {
        if (nums.length == 1) {
            return nums;
        }
        int mid = nums.length / 2;

        int[] left = new int[mid];
        int[] right = new int[nums.length - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = nums[i];
        }

        int counter = 0;
        for (int i = mid; i < nums.length; i++) {
            right[counter] = nums[i];
            counter++;
        }

        return merge(mergeSort(left), mergeSort(right));
    }

    private int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int k = 0;
        int i = 0;
        int j = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                result[k] = left[i];
                i++;
            } else {
                result[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < left.length) {
            result[k] = left[i];
            k++;
            i++;
        }

        while (j < right.length) {
            result[k] = right[j];
            k++;
            j++;
        }
        return result;
    }

}
