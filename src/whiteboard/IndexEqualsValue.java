package whiteboard;

public class IndexEqualsValue {

    // O(log(n)) time | O(1) space
    // random: 14/07/2022 - 24/09/2022
    public int indexEqualsValue(int[] array) {
        // Write your code here.
        int start = 0;
        int end = array.length - 1;
        int min = Integer.MAX_VALUE;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (array[mid] == mid) {
                min = Math.min(mid, min);
                end--;
            } else if (array[mid] > mid) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return min != Integer.MAX_VALUE ? min : -1;
    }
    
}
