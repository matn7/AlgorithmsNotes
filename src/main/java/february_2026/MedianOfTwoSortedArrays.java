package february_2026;

public class MedianOfTwoSortedArrays {

    // O(log(min(n,m))) time | O(1) space
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums2.length < nums1.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int m = nums1.length;
        int n = nums2.length;
        int half_total_len = (m + n) / 2;
        int left = 0, right = m;
        // A median always exists in a non-empty array, so continue binary search until it's found.
        while (true) {
            int L1_index = (left + right) / 2 - 1;
            int L2_index = half_total_len - (L1_index + 1) - 1;
            // Set to -infinity or +infinity if out of bounds.
            int L1 = (L1_index < 0) ? Integer.MIN_VALUE:nums1[L1_index];
            int R1 = (L1_index + 1 >= m) ? Integer.MAX_VALUE:nums1[L1_index + 1];
            int L2 = (L2_index < 0) ? Integer.MIN_VALUE:nums2[L2_index];
            int R2 = (L2_index + 1 >= n) ? Integer.MAX_VALUE:nums2[L2_index + 1];
            // If 'L1 > R2', then 'L1' is too far to the right. Narrow the search space toward the left.
            if (L1 > R2) {
                right = (L1_index + 1) - 1;
            }
            // If 'L2 > R1', then 'L1' is too far to the left. Narrow the search space toward the right.
            else if (L2 > R1) {
                left = (L1_index + 1) + 1;
            }
            // If both 'L1' and 'L2' are less than or equal to both 'R1' and 'R2', we found the correct slice.
            else {
                if ((m + n) % 2==0) {
                    return (Math.max(L1, L2) + Math.min(R1, R2)) / 2.0;
                } else {
                    return Math.min(R1, R2);
                }
            }
        }
    }

}
