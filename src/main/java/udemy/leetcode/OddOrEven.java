package udemy.leetcode;

public class OddOrEven {

    // Find whether number N is odd or even
    // 19   ->  10011

    //   10011
    // & 00001
    // --------
    //   00001  --> odd

    public static void main(String[] args) {
        int n = 18;
        OddOrEven oddOrEven = new OddOrEven();
        System.out.println(oddOrEven.isOdd(n));
    }

    public boolean isOdd(int n) {
        return ((n & 1) == 1);
    }

}
