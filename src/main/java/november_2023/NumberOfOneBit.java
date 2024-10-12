package november_2023;

public class NumberOfOneBit {

    public static void main(String[] args) {
        System.out.println(numberOfOneBit(23));
    }

    // O(log(n)) time | O(1) space
    public static int numberOfOneBit(int n) {
        int counter = 0;
        int BIT_MASK = 1;

        while (n > 0) {
            if ((n & BIT_MASK) == 1) {
                counter++;
            }
            n = n >> 1;
        }

        return counter;
    }

}
