package march_2025;

import october_2024.BrickWall;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianOfTwoSortedArrays2 {

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};

        MedianOfTwoSortedArrays2 median = new MedianOfTwoSortedArrays2();
        double result = median.findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }

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

            int Aleft = i > 0 ? A[i - 1] : Integer.MIN_VALUE;
            int Aright = i < A.length ? A[i] : Integer.MAX_VALUE;
            int Bleft = j > 0 ? B[j - 1] : Integer.MIN_VALUE;
            int Bright = j < B.length ? B[j] : Integer.MAX_VALUE;

            // partition is correct
            if (Aleft <= Bright && Bleft <= Aright) {
                // odd
                if (total % 2 != 0) {
                    return Math.max(Aleft, Bleft);
                }
                // even
                return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;
            } else if (Aleft > Bright) {
                r = i - 1;
            } else {
                l = i + 1;
            }
        }
        return -1;
    }

}
