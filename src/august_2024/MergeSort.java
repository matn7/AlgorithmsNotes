package august_2024;

public class MergeSort {

    public static void main(String[] args) {
        int[] array = {8, 5, 2, 9, 5, 6, 3};

        int[] result = mergeSort(array);
        System.out.println(result);
    }

    // O(nlog(n)) time | O(n) space
    public static int[] mergeSort(int[] array) {
        if (array.length == 1) {
            return array;
        }
        int mid = array.length / 2; // (0 + 6) / 2 = 3
        int[] leftHalf = new int[mid];
        for (int i = 0; i < mid; i++) {
            leftHalf[i] = array[i];
        }

        int[] rightHalf = new int[array.length - mid];
        int index = 0;
        for (int i = mid; i < array.length; i++) {
            rightHalf[index] = array[i];
            index++;
        }

        return merge(mergeSort(leftHalf), mergeSort(rightHalf));
    }

    private static int[] merge(int[] leftHalf, int[] rightHalf) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] result = new int[leftHalf.length + rightHalf.length];
        while (i < leftHalf.length && j < rightHalf.length) {
            if (leftHalf[i] < rightHalf[j]) {
                result[k] = leftHalf[i];
                i++;
            } else {
                result[k] = rightHalf[j];
                j++;
            }
            k++;
        }
        while (i < leftHalf.length) {
            result[k] = leftHalf[i];
            i++;
            k++;
        }
        while (j < rightHalf.length) {
            result[k] = rightHalf[j];
            j++;
            k++;
        }
        return result;
    }

}
