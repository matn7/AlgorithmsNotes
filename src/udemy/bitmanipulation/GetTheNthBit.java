package udemy.bitmanipulation;

public class GetTheNthBit {

    // check the nth bit in an integer
    // return 1 if it is 1 and 0 if it is 0
    // how do you identify a specific bit in a series of bits?
    int get_nth_bit(int num, int n) {
        int check_bit = 1 << n; // move the check bit to the nth position

        int and_bit = num & check_bit; // bitwise and & with the number to check
        if (and_bit == check_bit) {
            return 1;
        }
        return 0;
    }

}
