package february_2025;

public class TurbulentArray {

    public static void main(String[] args) {
        int[] arr = {9, 4, 2, 10, 7, 8, 8, 1, 9};
        TurbulentArray turbulentArray = new TurbulentArray();
        int result = turbulentArray.maxTurbulenceSize(arr);
        System.out.println(result);
    }

    public int maxTurbulenceSize(int[] arr) {
        String prev = "";
        int max = 1;
        int l = 0;
        int r = 1;

        while (r < arr.length) {
            if (arr[r - 1] < arr[r] && !"<".equals(prev)) {
                max = Math.max(max, r - l + 1);
                r++;
                prev = "<";
            } else if (arr[r - 1] > arr[r] && !">".equals(prev)) {
                max = Math.max(max, r - l + 1);
                r++;
                prev = ">";
            } else {
                r = (arr[r - 1] == arr[r]) ? r + 1 : r;
                l = r - 1;
                prev = "";
            }
        }
        return max;
    }

}
