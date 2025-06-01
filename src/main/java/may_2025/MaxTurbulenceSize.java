package may_2025;

public class MaxTurbulenceSize {

    public static void main(String[] args) {
        int[] arr = {9,4,2,10,7,8,8,1,9};

        MaxTurbulenceSize maxTurbulenceSize = new MaxTurbulenceSize();
        int result = maxTurbulenceSize.maxTurbulenceSize(arr);
        System.out.println(result);
    }

    public int maxTurbulenceSize(int[] arr) {
        if (arr.length <= 1) {
            return arr.length;
        }
        int l = 0;
        int r = 1;
        String curr = arr[r] > arr[r - 1] ? "<" : ">";
        int max = 0;
        while (r < arr.length) {
            if (arr[r] > arr[r - 1] && curr.equals("<")) {
                r++;
                curr = ">";
            } else if (arr[r] < arr[r - 1] && curr.equals(">")) {
                r++;
                curr = "<";
            } else {
                if (arr[r] == arr[r - 1]) {
                    l = r;
                } else {
                    l = r - 1;
                }
                r++;
            }
            max = Math.max(max, r - l);
        }
        return max;
    }

}
