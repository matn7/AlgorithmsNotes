package udemy.leetcode;

public class SearchInGivenRange {

    public static void main(String[] args) {
        // Q2: Search the target element in the given array, but specify range.
        int[] arr = {14, 20, 47, 51, 60, 21, 4, 9};
        int target = 60;
        SearchInGivenRange searchInGivenRange = new SearchInGivenRange();
        searchInGivenRange.linearSearch3(arr, target, 1, 6);
    }

    public boolean linearSearch3(int[] arr, int target, int start, int end) {
        if (arr.length == 0) {
            return false;
        }
        for (int index = start; index < end; index++) {
            int element = arr[index];
            if (element == target) {
                return true;
            }
        }
        return false;
    }

}
