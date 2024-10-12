package udemy.bitmanipulation;

public class PrintBits {

    public static void main(String[] args) {
        print_bits(128);
    }

    static void print_bits(int num) {
        long i;
        System.out.print("0");
        for (i = 1 << 30; i > 0; i = i / 2) {
            if((num & i) != 0) {
                System.out.print("1");
            }
            else {
                System.out.print("0");
            }
        }
        System.out.println();
    }


}
