package december_2025;

public class StrobogrammaticNumber2 {

    // O(n) time | O(1) space
    public boolean isStrobogrammatic(String num) {

        int i = 0;
        int j = num.length() - 1;

        while (i <= j) {
            char a = num.charAt(i);
            char b = num.charAt(j);
            if (!checkNums(a, b)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean checkNums(char a, char b) {
        return (a == '0' && b == '0') || (a == '1' && b == '1') ||
                (a == '8' && b == '8') || (a == '6' && b == '9') ||
                (a == '9' && b == '6');
    }

}
