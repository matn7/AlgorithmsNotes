package veryhard;

public class MergeSort {

    public static void main(String[] args) {
        int[] array = {8, 5, 2, 9, 5, 6, 3};

        int[] result = mergeSort(array);

        for (int element : result) {
            System.out.print(element + " ");
        }
    }

    // O(nlog(n)) time | O(n) space
    public static int[] mergeSort(int[] array) {
        // Write your code here.
        if (array.length == 1) {
            return array;
        }

        int[] auxiliaryArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            auxiliaryArray[i] = array[i];
        }

        mergeDortHelper(array, 0, array.length - 1, auxiliaryArray);

        return array;
    }

    private static void mergeDortHelper(int[] mainArray, int startIdx, int endIdx, int[] auxiliaryArray) {
        if (startIdx == endIdx) {
            return;
        }
        int middleIdx = (startIdx + endIdx) / 2;
        mergeDortHelper(auxiliaryArray, startIdx, middleIdx, mainArray);
        mergeDortHelper(auxiliaryArray, middleIdx + 1, endIdx, mainArray);

        doMerge(mainArray, startIdx, middleIdx, endIdx, auxiliaryArray);

    }

    private static void doMerge(int[] mainArray, int startIdx, int middleIdx, int endIdx, int[] auxiliaryArray) {
        int k = startIdx;
        int i = startIdx;
        int j = middleIdx + 1;

        while (i <= middleIdx && j <= endIdx) {
            if (auxiliaryArray[i] <= auxiliaryArray[j]) {
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


//    // O(nlog(n)) time | O(nlog(n)) space
//    public static int[] mergeSort(int[] array) {
//        // Write your code here.
//        if (array.length == 1) {
//            return array;
//        }
//
//        int middleIdx = array.length / 2;
//        int[] leftHalf = new int[middleIdx];
//        for (int i = 0; i < middleIdx; i++) {
//            leftHalf[i] = array[i];
//        }
//
//        int[] rightHalf = new int[array.length - middleIdx];
//        int counter = 0;
//        for (int i = middleIdx; i < array.length; i++) {
//            rightHalf[counter] = array[i];
//            counter++;
//        }
//
//        return mergeSortedArray(mergeSort(leftHalf), mergeSort(rightHalf));
//    }
//
//    private static int[] mergeSortedArray(int[] leftHalf, int[] rightHalf) {
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
//
//        while (i < leftHalf.length) {
//            sortedArray[k] = leftHalf[i];
//            i++;
//            k++;
//        }
//
//        while (j < rightHalf.length) {
//            sortedArray[k] = rightHalf[j];
//            j++;
//            k++;
//        }
//
//        return sortedArray;
//    }

}
