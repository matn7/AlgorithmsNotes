package january_2024;

public class SortColors {

    public static void main(String[] args) {
        int[] colors = {1, 3, 2, 1, 2, 2, 3, 1, 1, 3, 2, 1, 1, 1, 2, 3, 3, 2, 1};

        sortColors(colors);
    }

    // O(n) time | O(1) space
    public static int[] sortColors(int[] colors) {
        // [1, 3, 2, 1, 2, 2, 3]
        //  s                 e
        //  idx
        int start = 0;
        int end = colors.length - 1;
        int index = 0;

        while (index <= end) {
            if (colors[index] == 1) {
                swap(colors, start, index);
                start++;
                index++;
            } else if (colors[index] == 3) {
                swap(colors, end, index);
                end--;
            } else {
                index++;
            }
        }

        return colors;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
