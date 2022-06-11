package whiteboard;

public class SingleCycleCheck {

    public static void main(String[] args) {
//        int[] array = {2, 3, 1, -4, -4, 2};
//        int[] array = {1, 1, 1, 1, 2};
        int[] array = {2, 2, -1};

        boolean result = hasSingleCycle(array);
        System.out.println();
    }

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

}
