package hard;

public class SearchForRange {

    public static void main(String[] args) {
//        int[] array = {0, 1, 21, 33, 45, 45, 45, 45, 45, 45, 61, 71, 73};
//        int[] array = {0, 1, 21, 33, 45, 45, 45, 45, 45, 45, 45, 45, 45};
        int[] array = {5, 7, 7, 8, 8, 10};
//        int[] array = {0, 1, 21, 33, 45, 61, 71, 73};

//        int result = binarySearch(array, 45);
        int[] ints = searchForRange(array, 10);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    public static int[] searchForRange(int[] array, int target) {

        if (binarySearch(array, target) == -1) {
            return new int[] {-1, -1};
        }
        int[] ints = searchForRangeRec(array, target, 0);
        return ints;
    }

    public static int binarySearch(int[] array, int target) {
        int min = 0;
        int max = array.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        return -1;
    }

    public static int[] searchForRangeRec(int[] array, int target, int carry) {
        // Write your code here.
        int min = 0;
        int max = array.length - 1;
        int left = 0;
        int right = 0;

        int mid = (min + max) / 2;
        if (array[mid] == target) {
            if (array.length == 1) {
                if (carry == -1) {
                    return new int[] {mid, mid};
                }
                return new int[] {mid + carry, mid + carry};
            }
            // means in left and right there is a number
            right = searchHelper(array, mid + 1, max, target);
            // check to right if target exists if so move right
            if (right < array.length - 1 && array[right + 1] == target) {
                while (array[right] == target && right < array.length - 1) {
                    right++;
                }
            }

            left = searchHelper(array, min, mid - 1, target);
            if (left > 0 && array[left - 1] == target) {
                while (array[left] == target && left >= 0) {
                    left--;
                }
            }
            // check to left if target exists if so move
            return new int[] {left + carry, right + carry};
        }

        if (array[mid] < target) {
            // only elements are from right sub array
            int[] newArray = new int[array.length / 2];
            int counter = 0;
            for (int i = mid + 1; i < array.length; i++) {
                newArray[counter] = array[i];
                counter++;
            }

            mid = mid + 1;
            return searchForRangeRec(newArray, target, carry + mid);
        }

        if (array[mid] > target) {
            int[] newArray = new int[array.length / 2];
            int counter = 0;
            for (int i = 0; i < array.length / 2; i++) {
                newArray[counter] = array[i];
                counter++;
            }

            mid = mid + 1;
            return searchForRangeRec(newArray, target, mid - carry);
        }

        return new int[] {-1, -1};
    }

    private static int searchHelper(int[] array, int min, int max, int target) {
        int mid = (min + max) / 2;
        if (array[mid] == target) {
            return mid;
        } else if (array[mid] < target) {
            return searchHelper(array, mid + 1, max, target);
        } else {
            return searchHelper(array, min, mid - 1, target);
        }
    }

}
