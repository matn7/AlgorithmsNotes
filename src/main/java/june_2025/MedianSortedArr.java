package june_2025;

public class MedianSortedArr {

    public static void main(String[] args) {
//        int[] nums1 = {1, 2, 3, 4, 5, 6, 7, 8};
//        int[] nums2 = {8, 9, 10, 11};

        int[] nums1 = {1, 3};
        int[] nums2 = {2};

        MedianSortedArr medianSortedArr = new MedianSortedArr();
        double result = medianSortedArr.findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }

    // O(log(min(n,m)) time | O(1) space
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A = nums1;
        int[] B = nums2;

        if (B.length < A.length) {
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
                R = i - 1;
            } else {
                L = i + 1;
            }
        }
        return -1;
    }

}


