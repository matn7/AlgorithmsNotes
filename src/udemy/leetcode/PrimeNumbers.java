package udemy.leetcode;

public class PrimeNumbers {

    public static void main(String[] args) {
        PrimeNumbers primeNumbers = new PrimeNumbers();
        for (int i = 1 ; i <= 20; i++) {
            System.out.println(i + " is prime: " + primeNumbers.checkPrime2(i));
        }
        boolean prime = primeNumbers.checkPrime(14);
        System.out.println(prime);
    }

    public boolean checkPrime(int n) {

        if (n <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.pow(n, 0.5); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean checkPrime2(int n) {

        if (n <= 1) {
            return false;
        }
        int c = 2;
        while (c * c <= n) {
            if (n%c == 0) {
                return false;
            }
            c++;
        }
        return true;
    }

}
