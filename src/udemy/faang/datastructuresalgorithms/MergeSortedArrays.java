package udemy.faang.datastructuresalgorithms;


public class MergeSortedArrays {

    public static void main(String[] args) {
        int[] arrOne = {0, 3, 4, 31};
        int[] arrTwo = {4, 6, 30};

        MergeSortedArrays mergeSortedArrays = new MergeSortedArrays();
        mergeSortedArrays.mergeSortedArrays(arrOne, arrTwo);
    }

    // O(n + m) time | O(n + m) space
    public int[] mergeSortedArrays(int[] arrOne, int[] arrTwo) {
        if (arrOne.length == 0) {
            return arrTwo;
        }
        if (arrTwo.length == 0) {
            return arrOne;
        }
        int[] newArr = new int[arrOne.length + arrTwo.length];
        int first = 0;
        int second = 0;
        int idx = 0;
        while (first < arrOne.length && second < arrTwo.length) {
            int firstVal = arrOne[first];
            int secondVal = arrTwo[second];
            if (firstVal <= secondVal) {
                newArr[idx] = firstVal;
                first++;
            } else {
                newArr[idx] = secondVal;
                second++;
            }
            idx++;
        }

        while (first < arrOne.length) {
            newArr[idx] = arrOne[first];
            idx++;
            first++;
        }

        while (second < arrTwo.length) {
            newArr[idx] = arrTwo[second];
            idx++;
            second++;
        }
        return newArr;
    }

}
