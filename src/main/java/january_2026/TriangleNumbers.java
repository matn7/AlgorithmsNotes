package january_2026;

public class TriangleNumbers {

    public int triangleNumbers(int n) {
        if (n % 2 != 0) {
            return 2;
        } else if (n % 4 == 0) {
            return 3;
        }
        return 4;
    }

}
