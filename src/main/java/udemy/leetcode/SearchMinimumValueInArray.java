package udemy.leetcode;

public class SearchMinimumValueInArray {

    public static void main(String[] args) {
        // Q3: Search the minimum value in array
        SearchMinimumValueInArray search = new SearchMinimumValueInArray();
        int[] arr = {10, 5, 0, -3, -7, 41};
        System.out.println(search.linearSearch4(arr));
    }

    public int linearSearch4(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
}
