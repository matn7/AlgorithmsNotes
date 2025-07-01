package june_2025;


public class LongestTurbulentSubarray {

    public static void main(String[] args) {
        int[] arr = {9,4,2,10,7,8,8,1,9};

        LongestTurbulentSubarray longestTurbulentSubarray = new LongestTurbulentSubarray();
        int result = longestTurbulentSubarray.maxTurbulenceSize(arr);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int maxTurbulenceSize(int[] arr) {
        int l = 0;
        int r = 1;
        int res = 1;
        String prev = "";

        while (r < arr.length) {
            if (arr[r] > arr[r - 1] && !">".equals(prev)) {
                res = Math.max(res, r - l + 1);
                r++;
                prev = ">";
            } else if (arr[r] < arr[r - 1] && !"<".equals(prev)) {
                res = Math.max(res, r - l + 1);
                r++;
                prev = "<";
            } else {
                r = (arr[r] == arr[r - 1]) ? r + 1 : r;
                l = r - 1;
                prev = "";
            }
        }

        return res;
    }

}
