package july_2025;

public class LongestTurbulentSubarr {

    public static void main(String[] args) {
        int[] arr = {9,4,2,10,7,8,8,1,9};

        LongestTurbulentSubarr longestTurbulentSubarr = new LongestTurbulentSubarr();
        int result = longestTurbulentSubarr.maxTurbulenceSize(arr);
        System.out.println(result);
    }

    // Intuition:
    // - Alternate, variable
    // - Two pointer technique
    // - How to treat corner cases like arr[r] = arr[r - 1]
    // Approach:
    // - L = 0, R = 0, prev = ""
    // - update max by keep iterating
    // Complexity:
    // O(n) time | O(1) space
    // Code:

    // [9, 4, 2, 10, 7, 8, 8, 1, 9]
    //                     L  R
    // arr[R] < arr[R - 1], prev = ""
    //      4 < 9           prev = "<"
    //      2 < 4 (wrong should be ">", we can check prev) R = R, L = R - 1, prev = ""
    //      2 < 4           prev = "<"
    //     10 > 2           prev = ">"
    //      7 < 10          prev = "<"
    //      8 > 7           prev = ">"
    //      R = R (wrong should be "<") R = R + 1, L = R - 1
    public int maxTurbulenceSize(int[] arr) {
        int l = 0;
        int r = 1;
        String prev = "";
        int res = 1;

        while (r < arr.length) {
            if (arr[r] < arr[r - 1] && !"<".equals(prev)) {
                res = Math.max(res, r - l + 1);
                r++;
                prev = "<";
            } else if (arr[r] > arr[r - 1] && !">".equals(prev)) {
                res = Math.max(res, r - l + 1);
                r++;
                prev = ">";
            } else {
                r = (arr[r] == arr[r - 1]) ? r + 1 : r;
                l = r - 1;
                prev = "";
            }
        }
        return res;
    }

}
