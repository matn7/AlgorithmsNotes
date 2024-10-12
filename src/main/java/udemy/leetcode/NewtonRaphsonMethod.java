package udemy.leetcode;

public class NewtonRaphsonMethod {

    // root = (x + (n/x)) / 2
    // n = 36
    // x = sqrt that user has assumed

    public static void main(String[] args) {

        NewtonRaphsonMethod newtonRaphsonMethod = new NewtonRaphsonMethod();
        System.out.println(newtonRaphsonMethod.sqrt(40));

    }

    public double sqrt(double n) {
        double x = n;
        double root;

        while (true) {
            root = (x + (n/x)) * 0.5;
            if (Math.abs(root - x) < 0.5) {
                break;
            }
            x = root;
        }
        return root;
    }


}
