package udemy.bitmanipulation;

public class SetTheNthBitToOne {

    int set_nth_bit_to_1(int num, int n) {
        int set_bit = 1 << n; // move the set bit to the nth position

        int result = num | set_bit;
        return result;
    }

}
