package educative.fastandslowpointers;

public class HappyNumber {

    public static void main(String[] args) {
        System.out.println(HappyNumber.find(23));
        System.out.println(HappyNumber.find(12));
    }

    // O(log(n)) time | O(1) space
    public static boolean find(int num) {
        int slow = num;
        int fast = num;
        do {
            slow = findSquareSum(slow); // move one step
            fast = findSquareSum(findSquareSum(fast)); // move two steps
        } while (slow != fast); // found cycle

        return slow == 1;
    }

    private static int findSquareSum(int num) {
        int sum = 0;
        int digit;
        while (num > 0) {
            digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        return sum;
    }

}
