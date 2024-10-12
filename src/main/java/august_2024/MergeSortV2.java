package august_2024;

public class MergeSortV2 {

    public static void main(String[] args) {
        int[] arr = {8, 5, 2, 9, 5, 6, 3};

        int[] result = mergeSort(arr);
        System.out.println(result);
    }

    public static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }

        int mid = arr.length / 2;
        int[] leftHalf = new int[mid];
        for (int i = 0; i < mid; i++) {
            leftHalf[i] = arr[i];
        }
        int[] rightHalf = new int[arr.length - mid];
        int counter = 0;
        for (int i = mid; i < arr.length; i++) {
            rightHalf[counter] = arr[i];
            counter++;
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
