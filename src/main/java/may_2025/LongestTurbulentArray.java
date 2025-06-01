package may_2025;

public class LongestTurbulentArray {

    public static void main(String[] args) {
        int[] arr = {9,4,2,10,7,8,8,1,9};
        LongestTurbulentArray longestTurbulentArray = new LongestTurbulentArray();
        int result = longestTurbulentArray.maxTurbulenceSize(arr);
        System.out.println(result);
    }

    public int maxTurbulenceSize(int[] arr) {
        int L = 0;
        int R = 1;
        char prev = ' ';
        int max = 1;

        while (R < arr.length) {
            if (arr[R - 1] > arr[R] && prev != '>') {
                prev = '>';
                max = Math.max(max, R - L + 1);
                R++;
            } else if (arr[R - 1] < arr[R] && prev != '<') {
                prev = '<';
                max = Math.max(max, R - L + 1);
                R++;
            } else {
                R = arr[R - 1] == arr[R] ? R + 1: R;
                L = R - 1;
                prev = ' ';
            }
        }
        return max;
    }


}
