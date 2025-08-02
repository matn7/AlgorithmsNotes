package july_2025;

public class MergeSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;

        MergeSortedArrays mergeSortedArrays = new MergeSortedArrays();
        mergeSortedArrays.merge(nums1, m, nums2, n);
        System.out.println();
    }

    // O(n) time | O(1) space
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int last = m + n - 1;
        while (m > 0 && n > 0) {
            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[last] = nums1[m - 1];
                m--;
            } else {
                nums1[last] = nums2[n - 1];
                n--;
            }
            last--;
        }
        while (m > 0) {
            nums1[last] = nums1[m - 1];
            m--;
            last--;
        }
        while (n > 0) {
            nums1[last] = nums2[n - 1];
            n--;
            last--;
        }
    }

}
