package udemy.leetcode;

public class FindSetResetBits {

    // find
    //   1100
    // & 0010    --> mask
    // -------
    //   0000

    // set
    //   1100
    // | 0010   --> mask
    // -------
    //   1110

    // reset
    //   1100
    // & 1011
    // -------
    //   1000

    public static void main(String[] args) {
        FindSetResetBits findSetResetBits = new FindSetResetBits();
        System.out.println(findSetResetBits.find(12, 3));
        System.out.println(findSetResetBits.set(12, 2));
        System.out.println(findSetResetBits.reset(12, 3));
    }

    public int find(int n, int i) {
        return n & (1 << (i - 1));
    }

    public int set(int n, int i) {
        return n | (1 << (i - 1));
    }

    public int reset(int n, int i) {
        return n & (~(1 << (i - 1)));
    }

}
