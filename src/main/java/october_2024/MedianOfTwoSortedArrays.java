package october_2024;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {3, 4};
        int[] nums2 = {};

        MedianOfTwoSortedArrays median = new MedianOfTwoSortedArrays();
        double medianSortedArrays = median.findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }

    // leetcode 4

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A = nums1;
        int[] B = nums2;
        int total = nums1.length + nums2.length;
        int half = total / 2;

        if (B.length < A.length) {
            int[] temp = A;
            A = B;
            B = temp;
        }

        int l = 0;
        int r = A.length - 1;

        while (true) {
            int i = (l + r) / 2; // A
            int j = half - i - 2; // index of

            int aleft = i >= 0 ? A[i] : Integer.MIN_VALUE;
            int aright = (i + 1) < A.length ? A[i + 1] : Integer.MAX_VALUE;
            int bleft = j >= 0 ? B[j] : Integer.MIN_VALUE;
            int bright = (j + 1) < B.length ? B[j + 1] : Integer.MAX_VALUE;

            // partition is correct
            if (aleft <= bright && bleft <= aright) {
                // odd
                if (total % 2 == 0) {
                    return Math.min(aright, bright);
                }
                return (Math.max(aleft, bleft) + Math.min(aright, bright)) / 2.0;
            } else if (aleft > bright) {
                r = i - 1;
            } else {
                l = i + 1;
            }
        }
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int[] merge = merge(nums1, nums2);
        if (merge.length % 2 == 0) {
            int idx1 = (merge.length - 1) / 2;
            int idx2 = idx1 + 1;
            return (merge[idx1] + merge[idx2]) / 2.0;
        }
        return merge[merge.length / 2];
    }


    private int[] merge(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                result[k] = nums1[i];
                i++;
            } else {
                result[k] = nums2[j];
                j++;
            }
            k++;
        }
        while (i < nums1.length) {
            result[k] = nums1[i];
            i++;
            k++;
        }
        while (j < nums2.length) {
            result[k] = nums2[j];
            j++;
            k++;
        }
        return result;
    }
}
