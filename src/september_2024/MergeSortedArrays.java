package september_2024;

public class MergeSortedArrays {

    public static void main(String[] args) {
//        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums1 = {1, 5, 5, 5, 8, 0, 0, 0};
        int[] nums2 = {2, 5, 6};

        MergeSortedArrays mergeSortedArrays = new MergeSortedArrays();
        mergeSortedArrays.merge(nums1, 5, nums2, 3);
    }

    // O(n+m) time | O(1) space
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // last index nums1
        int last = m + n - 1;

        // merge in reverse order
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
        // fill nums1 with leftover nums2
        while (n > 0) {
            nums1[last] = nums2[n - 1];
            n--;
            last--;
        }
    }

}
