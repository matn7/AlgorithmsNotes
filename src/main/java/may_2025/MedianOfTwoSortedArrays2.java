package may_2025;

public class MedianOfTwoSortedArrays2 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A = nums1;
        int[] B = nums2;

        if (A.length > B.length) {
            int[] temp = A;
            A = B;
            B = temp;
        }
        int total = A.length + B.length;
        int half = (total + 1) / 2;
        int L = 0;
        int R = A.length;

        while (L <= R) {
            int i = (L + R) / 2;
            int j = half - i;

            int Aleft = i > 0 ? A[i - 1] : Integer.MIN_VALUE;
            int Aright = i < A.length ? A[i] : Integer.MAX_VALUE;
            int Bleft = j > 0 ? B[j - 1] : Integer.MIN_VALUE;
            int Bright = j < B.length ? B[j] : Integer.MAX_VALUE;

            if (Aleft <= Bright && Aright >= Bleft) {
                if (total % 2 != 0) {
                    return Math.max(Aleft, Bleft);
                }
                return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;
            } else if (Aleft > Bright) {
                R = i - 1;
            } else {
                L = i + 1;
            }
        }
        return -1;
    }

}
