package numbers;

public class LeastCommonMultiple {

    // Znajdź największy wspólny dzielnik (GCD) liczb "a" i "b" używając algorytmu Euklidesa.
    // Oblicz LCM, dzieląc iloczyn liczb "a" i "b" przez GCD(a, b).

    // Calculate the greatest common divisor (GCD) using Euclidean algorithm
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    // O(log(min(a, b))) time | O(1) space
    // Calculate the least common multiple (LCM) of two numbers
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public static void main(String[] args) {
        int num1 = 12; // Replace with the first number
        int num2 = 18; // Replace with the second number

        int result = lcm(num1, num2);
        System.out.println("LCM of " + num1 + " and " + num2 + " is " + result);
    }

}
