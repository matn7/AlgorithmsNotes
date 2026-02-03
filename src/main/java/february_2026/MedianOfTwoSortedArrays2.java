package february_2026;

public class MedianOfTwoSortedArrays2 {

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

            int ALeft = i > 0 ? A[i - 1] : Integer.MIN_VALUE;
            int ARight = i < A.length ? A[i] : Integer.MAX_VALUE;
            int BLeft = j > 0 ? B[j - 1] : Integer.MIN_VALUE;
            int BRight = j < B.length ? B[j] : Integer.MAX_VALUE;

            if (ALeft <= BRight && BLeft <= ARight) {
                if (total % 2 != 0) {
                    return Math.max(ALeft, BLeft);
                }
                return (Math.max(ALeft, BLeft) + Math.min(ARight, BRight)) / 2.0;
            } else if (ALeft > BRight) {
                r = i - 1;
            } else {
                l = i + 1;
            }
        }
        return -1;
    }

}
