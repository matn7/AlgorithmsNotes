package whiteboard;

public class FirstDuplicateValueNOT {

    public static void main(String[] args) {
//        int[] array = {2, 1, 5, 2, 3, 3, 4};
        int[] array = {2, 1, 5, 2, 3, 3, 4};

        FirstDuplicateValueNOT first = new FirstDuplicateValueNOT();
        first.firstDuplicateValue(array);
    }

//    // O(n) time | O(n) space
//    public int firstDuplicateValue(int[] array) {
//        // Write your code here.
//        Map<Integer, Boolean> seen = new HashMap<>();
//        for (int idx = 0; idx < array.length; idx++) {
//            int element = array[idx];
//            if (seen.containsKey(element)) {
//                return element;
//            } else {
//                seen.put(element, Boolean.TRUE);
//            }
//        }
//        return -1;
//    }

    // O(n) time | O(1) space
    public int firstDuplicateValue(int[] array) {
        // Write your code here.
        for (int idx = 0; idx < array.length; idx++) {
            int currElement = array[idx];

            if (currElement < 0) {
                return currElement;
            }

            if (currElement > 0) {
                array[currElement] *= -1;
            }
        }
        return -1;
    }

}
