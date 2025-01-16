package november_2024;

public class StrStr {

    public static void main(String[] args) {
//        String haystack = "sadbutsad";
//        String needle = "sad";

        String haystack = "abc";
        String needle = "c";

        StrStr strStr = new StrStr();
        int result = strStr.strStr(haystack, needle);
        System.out.println(result);
    }

    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }
        if (haystack.length() == needle.length()) {
            return compareChars(haystack, needle.length(), needle) ? 0 : -1;
        }
        int[] nhash = createHash(needle);
        int[] hhash = new int[26];
        for (int i = 0; i < haystack.length(); i++) {
            if (i >= needle.length()) {
                if (compare(nhash, hhash) && compareChars(haystack, i, needle)) {
                    return i - needle.length();
                }
                int idxToRemove = haystack.charAt(i - needle.length()) - 'a';
                hhash[idxToRemove]--;
            }
            int idx = haystack.charAt(i) - 'a';
            hhash[idx]++;
        }
        if (compare(nhash, hhash) && compareChars(haystack, haystack.length(), needle)) {
            return haystack.length() - needle.length();
        }
        return -1;
    }

    private boolean compareChars(String h, int idx, String n) {
        int j = 0;
        for (int i = idx - n.length(); i < idx; i++) {
            if (h.charAt(i) != n.charAt(j)) {
                return false;
            }
            j++;
        }
        return true;
    }

    private boolean compare(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }

        }
        return true;
    }

    private int[] createHash(String str) {
        int[] hash = new int[26];
        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';
            hash[idx]++;
        }
        return hash;
    }

}
