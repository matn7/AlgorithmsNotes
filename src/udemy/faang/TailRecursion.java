package udemy.faang;

public class TailRecursion {

    public static void main(String[] args) {
        int result = tailFactorial(4, 1);
        System.out.println();
    }

    public static int tailFactorial(int x, int totalSoFar) {
        if (x == 0) {
            return totalSoFar;
        } else {
            return tailFactorial(x - 1, totalSoFar * x);
        }
    }

}
