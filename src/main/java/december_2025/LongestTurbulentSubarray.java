package december_2025;

public class LongestTurbulentSubarray {

    public static void main(String[] args) {
        int[] arr = {9,4,2,10,7,8,8,1,9};
        LongestTurbulentSubarray longestTurbulentSubarray = new LongestTurbulentSubarray();
        int result = longestTurbulentSubarray.maxTurbulenceSize(arr);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int maxTurbulenceSize(int[] arr) {
        String prev = "";
        int L = 0;
        int R = 1;
        int maxLen = 1;

        while (R < arr.length) {
            if (arr[R] > arr[R - 1] && !prev.equals(">")) {
                maxLen = Math.max(maxLen, R - L + 1);
                prev = ">";
                R++;
            } else if (arr[R] < arr[R - 1] && !prev.equals("<")) {
                maxLen = Math.max(maxLen, R - L + 1);
                prev = "<";
                R++;
            } else {
                R = arr[R] == arr[R - 1] ? R + 1 : R;
                L = R - 1;
                prev = "";
            }
        }
        return maxLen;
    }


}
