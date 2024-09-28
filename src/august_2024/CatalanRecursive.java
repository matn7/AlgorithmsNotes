package august_2024;

public class CatalanRecursive {

    public static void main(String[] args) {

    }

    // O(2^n) time | O(n) space
    public static long catalanRecursive(int n) {
        if (n <= 1) {
            return 1;
        }
        long result = 0;
        for (int i = 0; i < n; i++) {
            result += catalanRecursive(i) * catalanRecursive(n - 1 - i);
        }
        return result;
    }

}
