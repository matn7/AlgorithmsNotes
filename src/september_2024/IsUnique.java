package september_2024;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class IsUnique {

    public static void main(String[] args) {
        IsUnique isUnique = new IsUnique();
        System.out.println(isUnique.isUnique("abc")); // true
        System.out.println(isUnique.isUnique("abcdea")); // false

        System.out.println(isUnique.isUnique2("abc")); // true
        System.out.println(isUnique.isUnique2("abcdea")); // false

        System.out.println(isUnique.isUniqueChars("abc")); // true
        System.out.println(isUnique.isUniqueChars("abcdea")); // false
    }

    // O(n) time | O(n) space
    public boolean isUnique(String str) {
        Set<Character> charsSet = new HashSet<>();

        for (char c : str.toCharArray()) {
            if (charsSet.contains(c)) {
                return false;
            }
            charsSet.add(c);
        }
        return true;
    }

    // O(nlog(n)) time | O(1) space
    public boolean isUnique2(String str) {
        if (str.length() <= 1) {
            return true;
        }
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        int i = 0;
        int j = 1;
        while (j < str.length()) {
            if (charArray[i] == charArray[j]) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }

    // O(n) time | O(1) space
    public boolean isUnique3(String str) {
        if (str.length() > 128) {
            return false;
        }
        boolean[] charsArr = new boolean[str.length()];

        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (charsArr[val]) {
                return false;
            }
            charsArr[val] = true;
        }
        return true;

    }

    // O(n) time | O(1) spacce
    public boolean isUniqueChars(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) {
                return false;
            }
            checker = checker | (1 << val);
        }
        return true;
    }

}
