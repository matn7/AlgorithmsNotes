package medium;

import java.util.ArrayList;
import java.util.List;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
//        String str = "abaxyzzyxf";
        String str = "b12365456321b";

        longestPalindromicSubstring(str);

        boolean result = isPalindrome("aba");
        System.out.println(result);
    }

    public static String longestPalindromicSubstring(String str) {
        // Write your code here.

        List<String> palindromes = new ArrayList<>();
        StringBuilder finalString = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int k = i - 1;
            int j = i + 1;

            finalString.setLength(0);
            System.out.println("Current idx: " + i + " | k: " + k + " | j: " + j);
            // for case aba
            finalString.append(str.charAt(i));
            while (isPalindrome(finalString.toString()) && k >= 0 && j < str.length()) {
                System.out.println("*****");
                finalString.insert(0, str.charAt(k)); // prepend
                k--;
                finalString.append(str.charAt(j));
                j++;
                System.out.println(finalString.toString());
                System.out.println("+++++");

                if (isPalindrome(finalString.toString())) {
                    palindromes.add(finalString.toString());
                }
            }

            finalString.setLength(0);
            // for case zz
            k = i - 1;
            j = i;
            while (isPalindrome(finalString.toString()) && k >= 0 && j < str.length()) {
                System.out.println("%%%%%");
                finalString.insert(0, str.charAt(k)); //.append(str.charAt(k)); // prepend
                k--;
                finalString.append(str.charAt(j)); // append
                j++;
                System.out.println(finalString.toString());
                System.out.println("^^^^^");

                if (isPalindrome(finalString.toString())) {
                    palindromes.add(finalString.toString());
                }
            }

            System.out.println("==============================");
        }

        String longest = palindromes.get(0);

        for (String palindrom : palindromes) {
            if (palindrom.length() > longest.length()) {
                longest = palindrom;
            }
        }

        return longest;
    }

    private static boolean isPalindrome(String str) {
        if (str.length() == 0 || str.length() == 1) {
            return true;
        }
        if (str.charAt(0) == str.charAt(str.length() - 1)) {
            return isPalindrome(str.substring(1,str.length()-1));
        } else {
            return false;
        }
    }
}

/*
            while (k >= 0) {
                stringBuilder.append(str.charAt(k));
                k--;
                count++;
            }
            stringBuilder.reverse();

//            System.out.print(stringBuilder.toString() + " ");

            stringBuilder.append(str.charAt(i));

            finalString.append(stringBuilder);

//            System.out.print(stringBuilder.toString() + " ");
            stringBuilder.setLength(0);
            while (j < str.length() && count > 0) {
                stringBuilder.append(str.charAt(j));
                j++;
                count--;
            }

//            System.out.println(stringBuilder.toString() + " " + isPalindrome(stringBuilder.toString()));

//            System.out.println(stringBuilder.toString());

            finalString.append(stringBuilder);

            System.out.println(finalString.toString());

            if (isPalindrome(finalString.toString())) {
                System.out.println(finalString.toString() + " PALINDROME");
            }
            stringBuilder.setLength(0);
            finalString.setLength(0);
*/
