package october_2023;

public class LeastCommonMultiple {

    public static void main(String[] args) {
        int a = 12;
        int b = 12;

        int result = leastCommonMultiple(a, b);
        System.out.println(result);
    }

    // O(log(min(a,b)) time | O(1) space
    public static int leastCommonMultiple(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

}
