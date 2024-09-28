package august_2024;

public class SingleCycleCheck {

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, -4, -4, 2};

        boolean result = singleCycleCheck(arr);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public static boolean singleCycleCheck(int[] arr) {
        int idx = 0;
        int counter = arr.length;

        while (counter >= 0) {
            int next = arr[idx] + idx;
            arr[idx] = 0;
            if (next > arr.length) {
                idx = next - arr.length;
            } else if (next < 0) {
                idx = arr.length + next;
            } else {
                idx = next;
            }
            counter--;
        }
        if (idx != 0) {
            return false;
        }
        for (int element : arr) {
            if (element != 0) {
                return false;
            }
        }
        return true;
    }

}
