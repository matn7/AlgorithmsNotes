package september_2025;

public class GreatestCommonDivisor {

    // min(m, n) * (m + n) time | O(n + m) space
    public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length(), len2 = str2.length();

        for (int l = Math.min(len1, len2); l > 0; l--) {
            if (isDivisor(l, len1, len2, str1, str2)) {
                return str1.substring(0, l);
            }
        }

        return "";
    }

    public boolean isDivisor(int l, int len1, int len2, String str1, String str2) {
        if (len1 % l != 0 || len2 % l != 0) {
            return false;
        }
        String sub = str1.substring(0, l);
        int f1 = len1 / l, f2 = len2 / l;
        return sub.repeat(f1).equals(str1) && sub.repeat(f2).equals(str2);
    }


}
