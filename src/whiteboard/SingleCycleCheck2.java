package whiteboard;

public class SingleCycleCheck2 {

    public static void main(String[] args) {
//        int[] array = {2, 3, 1, -4, -4, 2};
        int[] array = {1, -1, 1, -1};
        hasSingleCycle(array);
    }

    public static boolean hasSingleCycle(int[] array) {
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
