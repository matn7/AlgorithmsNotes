package udemy.leetcode;

public class FindUniqueElemInArray {

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 3, 2, 4, 6};
        FindUniqueElemInArray findUniqueElemInArray = new FindUniqueElemInArray();
        System.out.println(findUniqueElemInArray.uniqueNumber(arr));
    }

    // a ^ 1 = not a
    // a ^ 0 = a
    // a ^ a = 0

    public int uniqueNumber(int[] arr) {
        int unique = 0;

        for (int i : arr) {
            unique ^= i;
            // 0 ^ 2 = 2
            // 2 ^ 3 = 1
            System.out.println();
        }

        return unique;
    }

}
