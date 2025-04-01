package march_2025;

public class SingleCycleCheck {

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, -4, -4, 2};

        SingleCycleCheck singleCycleCheck = new SingleCycleCheck();
        boolean result = singleCycleCheck.hasSingleCycle(arr);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public boolean hasSingleCycle(int[] arr) {
        int pos = 0;
        int nums = arr.length;

        while (nums > 0) {
            int nextPos = pos + arr[pos];
            if (nextPos < 0) {
                nextPos = arr.length + nextPos;
            }
            if (nextPos > arr.length) {
                nextPos = nextPos - arr.length;
            }

            pos = nextPos;
            nums--;
        }
        return pos == 0;
    }

}
