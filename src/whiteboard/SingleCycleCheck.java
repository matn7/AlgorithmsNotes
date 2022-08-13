package whiteboard;

public class SingleCycleCheck {

    public static void main(String[] args) {
//        int[] array = {2, 3, 1, -4, -4, 2};
//        int[] array = {1, 1, 1, 1, 2};
        int[] array = {2, 2, -1};

        boolean result = hasSingleCycle(array);
        System.out.println();
    }

    // O(n) time | O(1) space
    // #2: 05/07/2022
    // rand: 10/08/2022
    public static boolean hasSingleCycle(int[] array) {
        // Write your code here.
        int i = 0;
        int counter = 0;
        int length = array.length;
        while (counter < length) {
            int currPos = i;
            int jump = array[i] % length;
            array[i] = 0;
            i = jump + currPos;
            if (i < 0) {
                i = length + i;
            }
            if (i >= length) {
                i = i - length;
            }
            counter++;
        }

        for (int element : array) {
            if (element != 0) {
                return false;
            }
        }
        return i == 0;
    }

    // O(n) time | O(1) space
    public static boolean hasSingleCycleMy(int[] array) {
        // Write your code here.
        int counter = array.length;
        int index = 0;
        int jump = array[index];
        boolean lastChecked = false;
        if (jump == 0) {
            return false;
        }
        while (counter > 0) {
            index = index + jump % array.length;
            if (index > array.length - 1) {
                index = index - array.length;
            }
            if (index < 0) {
                index = array.length + index;
            }
            if (index == array.length - 1) {
                lastChecked = true;
            }
            jump = array[index];
            counter--;
        }
        return index == 0 && lastChecked;
    }

}
