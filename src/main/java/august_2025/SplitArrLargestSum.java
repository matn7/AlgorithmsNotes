package august_2025;

public class SplitArrLargestSum {

    // O(n*log(s)) time | O(1) space
    public int splitArray(int[] nums, int k) {
        int l = 0;
        int r = 0;
        for (int n : nums) {
            l = Math.max(l, n);
            r += n;
        }
        int res = r;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (canSplit(mid, nums, k)) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return res;
    }

    private boolean canSplit(int largest, int[] nums, int k) {
        int subarray = 0;
        int curSum = 0;
        for (int n : nums) {
            curSum += n;
            if (curSum > largest) {
                subarray++;
                curSum = n;
            }
        }
        return subarray + 1 <= k;
    }

}
