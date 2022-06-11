package medium;

public class ThreeNumberSort {

    public static void main(String[] args) {
        int[] array = {1,0,0,-1,-1,0,1,1};
        int[] order = {0,1,-1};
        ThreeNumberSort threeNumberSort = new ThreeNumberSort();
        threeNumberSort.threeNumberSort(array, order);
    }

    // O(n) time | O(1) space
//    public int[] threeNumberSort(int[] array, int[] order) {
//        // Write your code here.
//        int firstIndex = 0;
//        for (int i = 0; i < array.length; i++) {
//            if (array[i] == order[0]) {
//                // swap
//                swap(array, firstIndex, i);
//                firstIndex++;
//            }
//        }
//
//        int lastIndex = array.length - 1;
//        for (int i = array.length - 1; i >= 0; i--) {
//            if (array[i] == order[2]) {
//                // swap
//                swap(array, lastIndex, i);
//                lastIndex--;
//            }
//        }
//
//        return array;
//    }
//
//    private void swap(int[] array, int index, int i) {
//        int temp = array[index];
//        array[index] = array[i];
//        array[i] = temp;
//        System.out.println();
//    }

    // O(n) time | O(1) space
//    public int[] threeNumberSort(int[] array, int[] order) {
//        // Write your code here.
//        int[] valueCounts = new int[order.length];
//
//        for (int i = 0; i < array.length; i++) {
//            if (array[i] == order[0]) {
//                valueCounts[0] += 1;
//            }
//            if (array[i] == order[1]) {
//                valueCounts[1] += 1;
//            }
//            if (array[i] == order[2]) {
//                valueCounts[2] += 1;
//            }
//        }
//
//        for (int i = 0; i < array.length; i++) {
//            if (i < valueCounts[0]) {
//                array[i] = order[0];
//            } else if (i < valueCounts[1] + valueCounts[0]) {
//                array[i] = order[1];
//            } else {
//                array[i] = order[2];
//            }
//        }
//
//        return array;
//    }

    // O(n) time | O(1) space
    public int[] threeNumberSort(int[] array, int[] order) {
        int firstValue = order[0];
        int secondValue = order[1];

        // keep track of the idx where the values are stored
        int firstIdx = 0;
        int secondIdx = 0;
        int thirdIdx = array.length - 1;

        while (secondIdx <= thirdIdx) {
            int value = array[secondIdx];

            if (value == firstValue) {
                swap(array, secondIdx, firstIdx);
                firstIdx++;
                secondIdx++;
            } else if (value == secondValue) {
                secondIdx++;
            } else {
                swap(array, secondIdx, thirdIdx);
                thirdIdx--;
            }
        }

        return array;
    }

    private void swap(int[] array, int index, int i) {
        int temp = array[index];
        array[index] = array[i];
        array[i] = temp;
        System.out.println();
    }
}
