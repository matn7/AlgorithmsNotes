package january_2026;

public class FixedPoint {

    public static void main(String[] args) {
        int[] arr = {-10,-5,-2,0,4,5,6,7,8,9,10};
        FixedPoint fixedPoint = new FixedPoint();
        int result = fixedPoint.fixedPoint(arr);
        System.out.println(result);
    }

    // O(log(n)) time | O(1) space
    public int fixedPoint(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        int min = Integer.MAX_VALUE;

        while (l <= r) {
            int m = (l + r) / 2;
            if (m == arr[m]) {
                min = Math.min(min, m);
                r = m - 1;
            } else if (m > arr[m]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

}
