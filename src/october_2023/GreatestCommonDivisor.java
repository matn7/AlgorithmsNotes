package october_2023;

public class GreatestCommonDivisor {

    public static void main(String[] args) {
        int result = gcd(18, 12);
        System.out.println(result);
    }

    // O(log(min(a,b)) time | O(1) space
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

}
