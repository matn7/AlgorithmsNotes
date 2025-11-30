package november_2025;

public class LongestTurbulentArray {

    public static void main(String[] args) {
        int[] arr = {9, 4, 2, 10, 7, 8, 8, 1, 9};
//        int[] arr = {4,8,12,16};

        LongestTurbulentArray longestTurbulentArray = new LongestTurbulentArray();
        int result = longestTurbulentArray.maxTurbulenceSize(arr);
        System.out.println(result);

    }

    // O(n) time | O(1) space
    public int maxTurbulenceSize(int[] arr) {
        int i = 0;
        int j = 1;
        int res = 1;
        String prev = "";

        while (j < arr.length) {
            if (arr[j] < arr[j - 1] && !prev.equals("<")) {
                res = Math.max(res, j - i + 1);
                j++;
                prev = "<";
            } else if (arr[j] > arr[j - 1] && !prev.equals(">")) {
                res = Math.max(res, j - i + 1);
                j++;
                prev = ">";
            } else {
                j = arr[j] == arr[j - 1] ? j + 1 : j;
                i = j - 1;
                prev = "";
            }
        }
        return res;
    }

}
