package july_2025;

public class StrStr {

    public static void main(String[] args) {
//        String haystack = "sadbutsad";
//        String needle = "sad";

//        String haystack = "leetcode";
//        String needle = "leeto";

        String haystack = "mississippi";
        String needle = "issip";

        StrStr strStr = new StrStr();
        int result = strStr.strStr(haystack, needle);
        System.out.println(result);
    }

    // O(n * l) time | O(1) space
    public int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length() + 1 - needle.length(); i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

}
