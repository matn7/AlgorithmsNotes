package october_2025;

public class LongestTurbulentSubarray {

    public static void main(String[] args) {
        int[] arr = {9,4,2,10,7,8,8,1,9};
//        int[] arr = {4,8,12,16};

        LongestTurbulentSubarray longestTurbulentSubarray = new LongestTurbulentSubarray();
        int result = longestTurbulentSubarray.maxTurbulenceSize(arr);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int maxTurbulenceSize(int[] arr) {
        int l = 0;
        int r = 1;
        int res = 1;
        String sign = "";

        while (r < arr.length) {
            if (arr[r] < arr[r - 1] && !"<".equals(sign)) {
                res = Math.max(res, r - l + 1);
                r++;
                sign = "<";
            } else if (arr[r] > arr[r - 1] && !">".equals(sign)) {
                res = Math.max(res, r - l + 1);
                r++;
                sign = ">";
            } else {
                r = arr[r] == arr[r - 1] ? r + 1: r;
                l = r - 1;
                sign = "";
            }
        }
        return res;
    }

}
