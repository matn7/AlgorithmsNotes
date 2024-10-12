package numbers;

public class BrilliantNumberChecker {
    // Approximation of Euler-Mascheroni constant (γ)
    private static final double EULER_MASCHERONI_CONSTANT = 0.57721566490153286060651209;

    // O(n) time | O(1) space
    // Function to check if a number is a Brilliant Number
    public static boolean isBrilliantNumber(int n) {
        double harmonicSumN = 0.0;
        double harmonicSumNPlus1 = 0.0;

        // Calculate the harmonic sum up to n and n+1
        for (int k = 1; k <= n + 1; k++) {
            harmonicSumN += 1.0 / k;
            if (k <= n) {
                harmonicSumNPlus1 += 1.0 / k;
            }
        }

        // Calculate the natural logarithm of n and n+1
        double lnN = Math.log(n);
        double lnNPlus1 = Math.log(n + 1);

        // Check if γ falls between the two sums
        return EULER_MASCHERONI_CONSTANT > (harmonicSumN - lnN) &&
                EULER_MASCHERONI_CONSTANT < (harmonicSumNPlus1 - lnNPlus1);
    }

    public static void main(String[] args) {
        int numberToCheck = 10; // Change this to the number you want to check

        for (int i = 2; i < 100; i++) {
            if (isBrilliantNumber(i)) {
                System.out.println(i + " is a Brilliant Number.");
            }
        }

    }
}