package medium;

public class ThreeNumberSortREPEAT {

    public static void main(String[] args) {
        int[] array = {1, 0, 0, -1, -1, 0, 1, 1};
        int[] order = {0, 1, -1};

        ThreeNumberSortREPEAT threeNumberSortREPEAT = new ThreeNumberSortREPEAT();
        int[] result = threeNumberSortREPEAT.threeNumberSort(array, order);
        System.out.println(result);

        // Bucket sort
        // |_| |_| |_|
        //  0   1  -1
    }

    // O(n) time | O(1) space
    // OK - repeated 09/02/2022
    //         fs                      t
    // array = [1, 0, 0, -1, -1, 0, 1, 1]
    // order = [0, 1, -1]
    public int[] threeNumberSort(int[] array, int[] order) {
        int firstValue = order[0]; // 0
        int secondValue = order[1]; // 1

        // keep track of the indicies where the values are stored
        int firstIdx = 0;
        int secondIdx = 0;
        int thirdIdx = array.length - 1;
        //                   f     t   s
        // array = [0, 0, 0, 1, 1, 1, -1, -1]
        while (secondIdx <= thirdIdx) {
            int value = array[secondIdx]; // 0

            if (value == firstValue) { // 0 == 0
                swap(secondIdx, firstIdx, array);
                firstIdx++;
                secondIdx++;
            } else if (value == secondValue) { // 1 == 1
                secondIdx++;
            } else {
                swap(secondIdx, thirdIdx, array);
                thirdIdx--;
            }
        }
        return array;
    }

    private void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

//    // O(n) time | O(1) space
//    // array = [1, 0, 0, -1, -1, 0, 1, 1]
//    // order = [0, 1, -1]
//    public int[] threeNumberSort(int[] array, int[] order) {
//        int firstValue = order[0]; // 0
//        int thirdValue = order[2]; // -1
//
//        int firstIdx = 0;
//        //            f
//        // [0, 0, 0, -1, -1, 1, 1, 1]
//        //                         i
//        for (int idx = 0; idx < array.length; idx++) {
//            if (array[idx] == firstValue) { // 1 == 0
//                swap(firstIdx, idx, array);
//                firstIdx++;
//            }
//        }
//
//        //                 t
//        // [0, 0, 0, 1, 1, 1, -1, -1]
//        //  i
//        int thirdIdx = array.length - 1;
//        for (int idx = array.length - 1; idx >= 0; idx--) {
//            if (array[idx] == thirdValue) { // 0 == -1
//                swap(thirdIdx, idx, array);
//                thirdIdx--;
//            }
//        }
//        return array;
//    }
//
//    private void swap(int i, int j, int[] array) {
//        int temp = array[i];
//        array[i] = array[j];
//        array[j] = temp;
//    }

//    // O(n) time | O(1) space
//    // array = [1, 0, 0, -1, -1, 0, 1, 1]
//    // order = [0, 1, -1]
//    public int[] threeNumberSort(int[] array, int[] order) {
//        int[] valueCounts = new int[order.length];
//
//        //                                 i
//        // array = [1, 0, 0, -1, -1, 0, 1, 1]
//        // valueCounts = [3, 3, 2]
//        for (int i = 0; i < array.length; i++) {
//            if (array[i] == order[0]) { // 1 == 0
//                valueCounts[0] += 1;
//            }
//            if (array[i] == order[1]) { // 1 == 1
//                valueCounts[1] += 1;
//            }
//            if (array[i] == order[2]) { // 1 == -1
//                valueCounts[2] += 1;
//            }
//        }
//
//        // order = [0, 1, -1]
//        // valueCounts = [3, 3, 2]
//        //                                 i
//        // array = [0, 0, 0, 1, 1, 1, -1, -1]
//        //          0  1  2  3  4  5  6  7
//        for (int i = 0; i < array.length; i++) {
//            if (i < valueCounts[0]) { // 3 < 3
//                array[i] = order[0];
//            } else if (i < valueCounts[1] + valueCounts[0]) { // 6 < 3 + 3
//                array[i] = order[1];
//            } else {
//                array[i] = order[2];
//            }
//        }
//
//        return array;
//    }

}
