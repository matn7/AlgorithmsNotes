package problems.medium;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        int result = main.foo(9);
        System.out.println(result);
    }

    int foo(int n) {
        int j = 1;
        int f = 1;
        while (f < n) {
            f = f * j++;
            System.out.print(f + " ");
        }
        return f;
    }

}
