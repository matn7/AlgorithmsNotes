package august_2024;

public class SingleCycleCheckV2 {

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, -4, -4, 20};

        boolean result = singleCycleCheck(arr);
        System.out.println(result);

    }

    // O(n) time | O(1) space
    public static boolean singleCycleCheck(int[] arr) {
        int index = 0;
        int count = arr.length;

        while (count > 0) {
            int nextIndex = index + (arr[index]) % arr.length;
            arr[index] = 0;

            if (nextIndex < 0) {
                nextIndex = arr.length + nextIndex;
            } else if (nextIndex > arr.length) {
                nextIndex = nextIndex - arr.length;
            }

            index = nextIndex;
            count--;
            System.out.println();
        }

        for (int a : arr) {
            if (a != 0) {
                return false;
            }
        }

        return index == 0;
    }


}
