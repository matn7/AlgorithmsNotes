package october_2024;

import java.util.HashMap;
import java.util.Map;

public class InterleavingString {

    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbbaccc";

        InterleavingString interleavingString = new InterleavingString();
        boolean result = interleavingString.isInterleave(s1, s2, s3);
        System.out.println(result);
    }

     public boolean isInterleave(String s1, String s2, String s3) {
         if (s1.length() + s2.length() != s3.length()) {
             return false;
         }
         Map<String, Boolean> dp = new HashMap<>();
         return helper(s1, 0, s2, 0, s3, 0, dp);
     }

     private boolean helper(String s1, int i1, String s2, int i2, String s3, int i3, Map<String, Boolean> dp) {
         if (i1 + i2 == s3.length()) {
             return true;
         }
         if (dp.containsKey(getKey(i1, i2))) {
             return dp.get(getKey(i1, i2));
         }
         if (i1 < s1.length() && s1.charAt(i1) == s3.charAt(i3)) {
             if (helper(s1, i1 + 1, s2, i2, s3, i3 + 1, dp)) {
                 return true;
             }
         }
         if (i2 < s2.length() && s2.charAt(i2) == s3.charAt(i3)) {
             return helper(s1, i1, s2, i2 + 1, s3, i3 + 1, dp);
         }
         dp.put(getKey(i1, i2), Boolean.FALSE);
         return false;
     }

     private String getKey(int i, int j) {
        return i + ":" + j;
     }
}
