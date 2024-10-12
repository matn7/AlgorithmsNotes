package numbers;

public class GreatestCommonDivisor {

    public static void main(String[] args) {
        int result = findGCD(18, 12);
        System.out.println(result);
    }

    // O(log(min(a,b))) time | O(1) space
    public static int findGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return findGCD(b, a % b);
    }

}
