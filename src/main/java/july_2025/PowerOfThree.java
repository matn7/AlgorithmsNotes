package july_2025;

public class PowerOfThree {

    public static void main(String[] args) {
        int n = 27;
        PowerOfThree powerOfThree = new PowerOfThree();
        boolean result = powerOfThree.isPowerOfThree(n);
        System.out.println(result);
    }

    // O(log3(n)) time | O(1) space
    public boolean isPowerOfThree(int n) {
        while (n >= 3) {
            if (n % 3 != 0) {
                return false;
            }
            n = n / 3;
        }
        return n == 1;
    }


}
