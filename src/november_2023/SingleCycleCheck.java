package november_2023;

public class SingleCycleCheck {

    public static void main(String[] args) {
        int[] array = {2, 3, 1, -4, -4, 2};

        boolean result = singleCycleCheck(array);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public static boolean singleCycleCheck(int[] array) {
        int elements = array.length;
        int nextIdx = 0;
        while (elements > 0) {
            int value = array[nextIdx];
            int jump = (nextIdx + value) % array.length;
            if (jump < 0) {
                jump = array.length + jump;
            }
            array[nextIdx] = 0;

            nextIdx = jump;
            elements--;
        }
        for (int element : array) {
            if (element != 0) {
                return false;
            }
        }

        return nextIdx == 0;
    }

}
