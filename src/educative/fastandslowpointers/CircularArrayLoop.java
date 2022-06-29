package educative.fastandslowpointers;

public class CircularArrayLoop {

    public static void main(String[] args) {
        System.out.println(CircularArrayLoop.loopExists(new int[] { 1, 2, -1, 2, 2 }));
        System.out.println(CircularArrayLoop.loopExists(new int[] { 2, 2, -1, 2 }));
        System.out.println(CircularArrayLoop.loopExists(new int[] { 2, 1, -1, -2 }));
    }

    // O(n^2) time | O(1) space
    public static boolean loopExists(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean isForward = arr[i] >= 0;
            int slow = i;
            int fast = i;

            do {
                slow = findNextIndex(arr, isForward, slow);
                fast = findNextIndex(arr, isForward, fast);
                if (fast != -1) {
                    fast = findNextIndex(arr, isForward, fast);
                }
            } while (slow != -1 && fast != -1 && slow != fast);

            if (slow != -1 && slow == fast) {
                return true;
            }
        }
        return false;
    }

    private static int findNextIndex(int[] arr, boolean isForward, int currentIndex) {
        boolean direction = arr[currentIndex] >= 0;
        if (isForward != direction) {
            return -1;
        }

        int nextIndex = (currentIndex + arr[currentIndex]) % arr.length;
        if (nextIndex < 0) {
            nextIndex += arr.length;
        }

        if (nextIndex == currentIndex) {
            nextIndex = -1;
        }

        return nextIndex;
    }

}
