package january_2026;

public class StrobogrammaticNumber {
    // O(n) time | O(1) space
    public boolean isStrobogrammatic(String num) {
        int l = 0;
        int r = num.length() - 1;

        while (l <= r) {
            if (!checkNum(num, l, r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    private boolean checkNum(String num, int i, int j) {
        return (num.charAt(i) == '0' && num.charAt(j) == '0') ||
                (num.charAt(i) == '1' && num.charAt(j) == '1') ||
                (num.charAt(i) == '6' && num.charAt(j) == '9') ||
                (num.charAt(i) == '8' && num.charAt(j) == '8') ||
                (num.charAt(i) == '9' && num.charAt(j) == '6');
    }

}
