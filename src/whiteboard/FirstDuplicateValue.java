package whiteboard;

public class FirstDuplicateValue {

    // O(n) time | O(1) space
    // #2: 27/06/2022
    // rand: 24/08/2022
    public int firstDuplicateValue(int[] array) {
        // Write your code here.
        for (int element : array) {
            int absValue = Math.abs(element);
            if (array[absValue - 1] < 0) {
                return absValue;
            }
            array[absValue - 1] *= -1;
        }
        return -1;
    }

}
