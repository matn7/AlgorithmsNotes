package november_2024;

public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A = nums1;
        int[] B = nums2;
        int total = A.length + B.length;
        int half = total / 2;

        if (B.length < A.length) {
            A = nums2;
            B = nums1;
        }

        int l = 0;
        int r = A.length - 1;

        while (true) {
            int i = (l + r) / 2; // A
            int j = half - i - 2; // B

            int Aleft = (i >= 0) ? A[i] : Integer.MIN_VALUE;
            int Aright = (i + 1 < A.length) ? A[i + 1] : Integer.MAX_VALUE;
            int Bleft = (j >= 0) ? B[j] : Integer.MIN_VALUE;
            int Bright = (j + 1 < B.length) ?  B[j + 1] : Integer.MAX_VALUE;

            // partition is correct
            if (Aleft <= Bright && Bleft <= Aright) {
                // odd
                if (total % 2 == 1) {
                    return Math.min(Aright, Bright);
                }
                // even
                return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;
            } else if (Aleft > Bright) {
                r = i - 1;
            } else {
                l = i + 1;
            }
        }
    }

}
