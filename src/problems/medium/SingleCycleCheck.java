package problems.medium;

public class SingleCycleCheck {

    public static void main(String[] args) {
        int[] array = {2, 3, 1, -4, -4, 2};

        hasSingleCycle(array);
    }

    // O(n) time | O(1) space
    // OK - repeated 07/02/2022
    public static boolean hasSingleCycle(int[] array) {
        // Write your code here.
        int numElementsVisited = 0;
        int currentIdx = 0;
        //          *  *  *   *   *  *
        //          0  1  2   3   4  5
        //         --------------------
        // array = [2, 3, 1, -4, -4, 2]
        while (numElementsVisited < array.length) { // 6 < 6
            if (numElementsVisited > 0 && currentIdx == 0) {
                return false;
            }
            numElementsVisited++; // 6
            currentIdx = getNextIdx(currentIdx, array);
        }
        return currentIdx == 0;
    }

    // getNextIdx(0, arr)
    private static int getNextIdx(int currentIdx, int[] array) {
        int jump = array[currentIdx]; // -4
        int nextIdx = (currentIdx + jump) % array.length;
        if (nextIdx >= 0) {
            return nextIdx; // 0
        }
        return nextIdx + array.length;
    }
}
