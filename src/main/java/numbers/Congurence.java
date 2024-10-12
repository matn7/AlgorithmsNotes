package numbers;

public class Congurence {

    // Kongruencja modulo jest relacją między dwiema liczbami, które mają tę samą resztę z dzielenia przez pewną liczbę całkowitą.

    public static void main(String[] args) {
        int a = 3;   // Współczynnik "a"
        int b = 2;   // Współczynnik "b"
        int m = 7;   // Moduł "m"

        int solution = solveCongruence(a, b, m);

        if (solution != -1) {
            System.out.println("Rozwiązanie kongruencji " + a + "x ≡ " + b + " (mod " + m + ") to x ≡ " + solution + " (mod " + m + ")");
        } else {
            System.out.println("Kongruencja nie ma rozwiązania.");
        }
    }

    // O(m) time (m - module) | O(1) space
    public static int solveCongruence(int a, int b, int m) {
        int gcd = gcd(a, m);

        if (b % gcd != 0) {
            return -1;  // Kongruencja nie ma rozwiązania
        }

        int a1 = a / gcd;
        int m1 = m / gcd;
        int b1 = b / gcd;

        int x = (b1 * modInverse(a1, m1)) % m1;
        x = (x + m1) % m1; // Upewniamy się, że x jest dodatnie

        return x;
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static int modInverse(int a, int m) {
        for (int x = 1; x < m; x++) {
            if ((a * x) % m == 1) {
                return x;
            }
        }
        return -1; // Brak odwrotności modulo
    }

}
