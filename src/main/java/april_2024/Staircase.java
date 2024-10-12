package april_2024;

public class Staircase {

    public static void main(String[] args) {
        int stairs = 4;

        System.out.println(climbStairs(stairs));
    }

    // O(n) time | O(1) space
    public static int climbStairs(int stairs) {
        int prevprev = 1;
        int prev = 2;

        if (stairs == 1) {
            return prevprev;
        }
        if (stairs == 2) {
            return prev;
        }

        int b = prev + prevprev;
        for (int i = 3; i <= stairs; i++) {
            b = prev + prevprev;
            prevprev = prev;
            prev = b;
        }
        return b;
    }

}
