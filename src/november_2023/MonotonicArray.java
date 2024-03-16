package november_2023;

public class MonotonicArray {

    public static void main(String[] args) {
        int[] arr = {-1, -5, -10, -1100, -1100, -1102, -9001};

        boolean result = monotonicArray(arr);
        System.out.println(result);
    }

    public static boolean monotonicArray(int[] arr) {
        if (arr.length <= 1) {
            return true;
        }

        boolean isDecreasing = false;
        boolean isIncreasing = false;
        boolean isFlat = false;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                if (isDecreasing) {
                    return false;
                }
                isIncreasing = true;
            } else if (arr[i] < arr[i - 1]) {
                if (isIncreasing) {
                    return false;
                }
                isDecreasing = true;
            } else {
                isFlat = true;
            }
        }

        return isDecreasing || isIncreasing || isFlat;
    }

}
