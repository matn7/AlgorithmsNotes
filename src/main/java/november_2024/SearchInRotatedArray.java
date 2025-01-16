package november_2024;

public class SearchInRotatedArray {

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;

        SearchInRotatedArray searchInRotatedArray = new SearchInRotatedArray();
        int result = searchInRotatedArray.search(nums, target);
        System.out.println(result);

    }

    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = (l + r) / 2;
            int M = nums[m];
            int L = nums[l];
            int R = nums[r];
            if (M == target) {
                return m;
            } else if (M > target) {
                // nums = [4, 5, 6, 7, 0, 1, 2], target = 0
                // nums = [7, 0, 1, 2, 4, 5, 6], target = 5
                if (L < M && L > target) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else {
                // [5, 1, 3]
                if (R > M && R < target) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
        }

        return -1;
    }

}
