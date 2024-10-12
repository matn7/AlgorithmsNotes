package september_2023;

public class IndexEqualsValue {

    public static void main(String[] args) {
        int[] array = {-5, -3, 0, 3, 4, 5, 9, 15, 16, 17, 18, 90, 91};

        IndexEqualsValue indexEqualsValue = new IndexEqualsValue();
        indexEqualsValue.indexEqualsValue(array);
    }

    // O(log(n)) time | O(1) space
    public int indexEqualsValue(int[] array) {
        // Write your code here.
        int start = 0;
        int end = array.length - 1;
        int currMin = Integer.MAX_VALUE;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (array[mid] == mid) {
                // min
                currMin = Math.min(currMin, mid);
                end = mid - 1;
            } else if (array[mid] > mid) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return currMin == Integer.MAX_VALUE ? -1 : currMin;
    }

}
