package december_2025;

public class StroboNum {

    // O(n) time | O(1) space
    public boolean isStrobogrammatic(String num) {
        int i = 0;
        int j = num.length() - 1;

        while (i <= j) {
            if (!checkNum(num, i, j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean checkNum(String num, int i, int j) {
        char a = num.charAt(i);
        char b = num.charAt(j);

        return (a == '0' && b == '0') ||
                (a == '1' && b == '1') ||
                (a == '6' && b == '9') ||
                (a == '8' && b == '8') ||
                (a == '9' && b == '6');
    }

}
