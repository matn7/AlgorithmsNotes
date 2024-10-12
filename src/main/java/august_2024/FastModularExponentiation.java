package august_2024;

public class FastModularExponentiation {

    // O(log(b)) time | O(1) space
    // Metoda obliczająca (a^b) % n
    public static long powerMod(long a, long b, long n) {
        long result = 1;
        a = a % n;

        while (b > 0) {
            // Jeśli b jest nieparzyste, pomnóż wynik przez a i zredukuj modulo n
            if ((b & 1) == 1) {
                result = (result * a) % n;
            }

            // b jest dzielone przez 2
            b >>= 1;

            // a jest podnoszone do kwadratu i redukowane modulo n
            a = (a * a) % n;
        }

        return result;
    }

    public static void main(String[] args) {
        long a = 2;
        long b = 10;
        long n = 1000;

        System.out.println("Result: " + powerMod(a, b, n)); // Wynik: 24, bo 2^10 % 1000 = 1024 % 1000 = 24
    }
}