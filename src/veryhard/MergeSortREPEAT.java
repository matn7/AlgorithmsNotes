package veryhard;

public class MergeSortREPEAT {

    public static void main(String[] args) {
        int[] array = {8, 5, 2, 9, 5, 6, 3};

        mergeSort(array);
    }

    // OK - repeated 20/02/2022
    // O(nlog(n)) time | O(n) space
    public static int[] mergeSort(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        int[] auxiliaryArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            auxiliaryArray[i] = array[i];
        }
        //                   0  1  2  3  4  5  6
        //                  ---------------------
        // array          = [8, 5, 2, 9, 5, 6, 3]
        // auxiliaryArray = [8, 5, 2, 9, 5, 6, 3]
        mergeSortHelper(array, 0, array.length - 1, auxiliaryArray);
        return array;
    }
    // rec([8, 5, 2, 9, 5, 6, 3]a, 6, 6, [8, 5, 2, 9, 5, 6, 3]m) => [3]
    // rec([8, 5, 2, 9, 5, 6, 3]a, 5, 5, [8, 5, 2, 9, 5, 6, 3]m) => [6]
    // rec([8, 5, 2, 9, 5, 6, 3]a, 4, 4, [8, 5, 2, 9, 5, 6, 3]m) => [5]
    // rec([8, 5, 2, 9, 5, 6, 3]a, 4, 5, [8, 5, 2, 9, 5, 6, 3]m)
    // rec([8, 5, 2, 9, 5, 6, 3]a, 4, 6, [8, 5, 2, 9, 5, 6, 3]m)  middle=5
    // rec([8, 5, 2, 9, 5, 6, 3]a, 3, 3, [8, 5, 2, 9, 5, 6, 3]m) => [9]
    // rec([8, 5, 2, 9, 5, 6, 3]a, 2, 2, [8, 5, 2, 9, 5, 6, 3]m) => [2]
    // rec([8, 5, 2, 9, 5, 6, 3]a, 2, 3, [8, 5, 2, 9, 5, 6, 3]m)  middle=2
    // rec([8, 5, 2, 9, 5, 6, 3]a, 1, 1, [8, 5, 2, 9, 5, 6, 3]m) => [5]
    // rec([8, 5, 2, 9, 5, 6, 3]a, 0, 0, [8, 5, 2, 9, 5, 6, 3]m) => [8]
    // rec([8, 5, 2, 9, 5, 6, 3]a, 0, 1, [8, 5, 2, 9, 5, 6, 3]m)  middle=0
    // rec([8, 5, 2, 9, 5, 6, 3]a, 0, 3, [8, 5, 2, 9, 5, 6, 3]m)  middle=1
    // rec([8, 5, 2, 9, 5, 6, 3]m, 0, 6, [8, 5, 2, 9, 5, 6, 3]a)  middle=3
    private static void mergeSortHelper(int[] mainArray, int startIdx, int endIdx, int[] auxiliaryArray) {
        if (startIdx == endIdx) {
            return;
        }
        int middleIdx = (startIdx + endIdx) / 2; // (0 + 1) / 2 = 0
        mergeSortHelper(auxiliaryArray, startIdx, middleIdx, mainArray);
        mergeSortHelper(auxiliaryArray, middleIdx + 1, endIdx, mainArray);
        doMerge(mainArray, startIdx, middleIdx, endIdx, auxiliaryArray);
    }

    // rec([5, 8, 2, 9, 5, 6, 3],0,3,6,[2, 5, 8, 9, 3, 5, 6])
    // rec([2, 5, 8, 9, 5, 6, 3],4,5,6,[5, 8, 2, 9, 5, 6, 3])
    // rec([5, 8, 2, 9, 5, 6, 3],4,4,5,[2, 5, 8, 9, 5, 6, 3])
    // rec([8, 5, 2, 9, 5, 6, 3],0,1,3,[5, 8, 2, 9, 5, 6, 3])
    // rec([5, 8, 2, 9, 5, 6, 3],2,2,3,[8, 5, 2, 9, 5, 6, 3])
    // rec([8, 5, 2, 9, 5, 6, 3],0,0,1,[8, 5, 2, 9, 5, 6, 3])
    private static void doMerge(int[] mainArray, int startIdx, int middleIdx, int endIdx, int[] auxiliaryArray) {
        printMethodArgs(mainArray, startIdx, middleIdx, endIdx, auxiliaryArray);

        int k = startIdx; // 0
        int i = startIdx; // 0
        int j = middleIdx + 1; // 2
        //  0  1  2  3  4  5  6
        // ---------------------
        //        i
        // [2, 5, 8, 9, 5, 6, 3] m
        //           j
        // [5, 8, 2, 9, 5, 6, 3] a
        //           k
        while (i <= middleIdx && j <= endIdx) {
            if (auxiliaryArray[i] <= auxiliaryArray[j]) { // 8 <= 9
                mainArray[k] = auxiliaryArray[i];
                i++;
            } else {
                mainArray[k] = auxiliaryArray[j];
                j++;
            }
            k++;
        }
        while (i <= middleIdx) {
            mainArray[k] = auxiliaryArray[i];
            i++;
            k++;
        }
        while (j <= endIdx) {
            mainArray[k] = auxiliaryArray[j];
            j++;
            k++;
        }
    }

    private static void printMethodArgs(int[] mainArray, int startIdx, int middleIdx, int endIdx, int[] auxiliaryArray) {
        System.out.print("[");
        for (int element : mainArray) {
            System.out.print(element + ", ");
        }
        System.out.print("]," + startIdx + "," + middleIdx + "," + endIdx + ",[");
        for (int element : auxiliaryArray) {
            System.out.print(element + ", ");
        }
        System.out.println("]");
    }

//    // O(nlog(n)) time | O(nlog(n)) space
//    public static int[] mergeSort(int[] array) {
//        // Write your code here.
//        if (array.length == 1) {
//            return array;
//        }
//        int middleIdx = array.length / 2;
//        int[] leftHalf = new int[middleIdx];
//        for (int i = 0; i < middleIdx; i++) {
//            leftHalf[i] = array[i];
//        }
//        int[] rightHalf = new int[array.length - middleIdx];
//        int counter = 0;
//        for (int i = middleIdx; i < array.length; i++) {
//            rightHalf[counter] = array[i];
//            counter++;
//        }
//        return mergeSortedArrays(mergeSort(leftHalf), mergeSort(rightHalf));
//    }
//
//    private static int[] mergeSortedArrays(int[] leftHalf, int[] rightHalf) {
//        int[] sortedArray = new int[leftHalf.length + rightHalf.length];
//        int k = 0;
//        int i = 0;
//        int j = 0;
//        while (i < leftHalf.length && j < rightHalf.length) {
//            if (leftHalf[i] <= rightHalf[j]) {
//                sortedArray[k] = leftHalf[i];
//                i++;
//            } else {
//                sortedArray[k] = rightHalf[j];
//                j++;
//            }
//            k++;
//        }
//        while (i < leftHalf.length) {
//            sortedArray[k] = leftHalf[i];
//            i++;
//            k++;
//        }
//        while (j < rightHalf.length) {
//            sortedArray[k] = rightHalf[j];
//            j++;
//            k++;
//        }
//        return sortedArray;
//    }

}
