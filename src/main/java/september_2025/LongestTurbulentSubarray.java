package september_2025;

public class LongestTurbulentSubarray {

    public static void main(String[] args) {
        int[] arr = {9,4,2,10,7,8,8,1,9};

        LongestTurbulentSubarray longestTurbulentSubarray = new LongestTurbulentSubarray();
        int result = longestTurbulentSubarray.maxTurbulenceSize(arr);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int maxTurbulenceSize(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }

        int L = 0;
        int R = 1;
        String prev = "";
        int res = 1;

        while (R < arr.length) {
            if (arr[R - 1] > arr[R] && !prev.equals(">")) {
                prev = ">";
                res = Math.max(res, R - L + 1);
                R++;
            } else if (arr[R - 1] < arr[R] && !prev.equals("<")) {
                prev = "<";
                res = Math.max(res, R - L + 1);
                R++;
            } else {
                R = arr[R] == arr[R - 1] ? R + 1 : R;
                prev = "";
                L = R - 1;
            }
        }
        return res;
    }

}
