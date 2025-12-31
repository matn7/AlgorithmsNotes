package december_2025;

public class StrobogrammaticNumber {

    // O(n) time | O(1) space
    public boolean isStrobogrammatic(String num) {
        // 0 -> 0
        // 1 -> 1 -> I -> I
        // 6 -> 9
        // 9 -> 6
        // 8 -> 8
        int i = 0;
        int j = num.length() - 1;
        while (i <= j) {
            char a = num.charAt(i);
            char b = num.charAt(j);
            if (!validChars(a, b)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean validChars(char a, char b) {
        if (a == '0' && b == '0') { return true; }
        if (a == '1' && b == '1') { return true; }
        if (a == '8' && b == '8') { return true; }
        if (a == '6' && b == '9') { return true; }
        if (a == '9' && b == '6') { return true; }
        return false;
    }

}
