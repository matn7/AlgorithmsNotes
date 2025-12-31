package december_2025;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] nums2 = {1, 2, 3, 4};
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7, 8};
    }

    // O(log(min(n,m)) time | O(1) space
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A = nums1;
        int[] B = nums2;
        int total = A.length + B.length;
        int half = (total + 1) / 2;

        if (B.length < A.length) {
            int[] temp = A;
            A = B;
            B = temp;
        }
        int l = 0;
        int r = A.length;

        while (l <= r) {
            int i = (l + r) / 2;
            int j = half - i;

            int aLeft = i > 0 ? A[i - 1] : Integer.MIN_VALUE;
            int aRight = i < A.length ? A[i] : Integer.MAX_VALUE;
            int bLeft = j > 0 ? B[j - 1] : Integer.MIN_VALUE;
            int bRight = j < B.length ? B[j] : Integer.MAX_VALUE;

            if (aLeft <= bRight && bLeft <= aRight) {
                if (total % 2 != 0) {
                    return Math.max(aLeft, bLeft);
                }
                return (Math.max(aLeft, bLeft) + Math.min(aRight, bRight)) / 2.0;
            } else if (aLeft > bRight) {
                r = i - 1;
            } else {
                l = i + 1;
            }
        }
        return -1;
    }

}
