package july_2025;

public class SearchInRotatedSortArr {

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;

        SearchInRotatedSortArr search = new SearchInRotatedSortArr();
        search.search(nums, target);
    }

    // Intuition:
    // - sorted - O(log(n))
    // - brute force - loop through all elems O(n)
    // Approach:
    // - binary search
    // - [L, m) - (m, R] compare
    // Complexity:
    // - O(log(n)) time | O(1) space
    // Code:

    //  L                 R
    // [4, 5, 6, 7, 0, 1, 2]
    //           M
    // +++++++++++
    // arr[M] == target? -> NO
    // arr[L] <= arr[M]: left sorted
    //      target >= arr[L] and target < arr[M]: R = M - 1
    //      else: L = M + 1
    // else:
    //      target > arr[M] and target <= arr[R]: L = M + 1
    //       else: R = M - 1

    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = (l + r) / 2; // (l + (r - l)/2)
            if (nums[m] == target) {
                return m;
            }
            if (nums[l] <= nums[m]) {
                if (target >= nums[l] && target < nums[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                if (target > nums[m] && target <= nums[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        return -1;
    }

}
