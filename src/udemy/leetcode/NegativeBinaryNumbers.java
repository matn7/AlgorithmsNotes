package udemy.leetcode;

public class NegativeBinaryNumbers {

    // 0 0 0 0 1 0 1 0
    //msb            lsb
    // msb (most significant bit) - it defines whether number is positive or negative
    // msb is 0 -> true  (positive)
    // msb is 1 -> false (negative)

    // step 1 - find complement of number
    // 00001010 -> 11110101
    // step 2 - add 1 to complement of number
    //   11110101
    // + 00000001
    //  -----------
    //   11110110
}
