package november_2023;

public class IndexEqualsValue {

    public static void main(String[] args) {
        int[] array = {-5, -3, 0, 3, 4, 5, 9, 15, 16, 17, 18, 19, 90, 91};
        int result = indexEqualsValue(array);
        System.out.println(result);
    }

    // O(log(n)) time | O(1) space
    public static int indexEqualsValue(int[] array) {
        int start = 0;
        int end = array.length - 1;
        int result = Integer.MAX_VALUE;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (array[mid] == mid) {
                result = Math.min(mid, result);
                end--;
            } else if (array[mid] > mid) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;

    }

}
