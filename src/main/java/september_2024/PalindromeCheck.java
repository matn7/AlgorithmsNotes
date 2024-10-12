package september_2024;

import java.util.HashMap;
import java.util.Map;

public class PalindromeCheck {

    public static void main(String[] args) {
        String str = "Tact coaoiiijj";

        PalindromeCheck palindromeCheck = new PalindromeCheck();
        boolean result = palindromeCheck.palindromeCheck(str);
        System.out.println(result);

        boolean result2 = palindromeCheck.palindromeCheck2(str);
        System.out.println(result2);

        boolean result3 = palindromeCheck.isPermutationOfPalindrome(str);
        System.out.println(result3);

        boolean result4 = palindromeCheck.isPermutationOfPalindrome2(str);
        System.out.println(result4);
    }

    public boolean palindromeCheck(String str) {
        Map<Character, Integer> freqMap = new HashMap<>();
        String processedStr = str.toLowerCase();

        for (char c : processedStr.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
            }
        }
        boolean oddCheck = false;
        for (Map.Entry<Character, Integer> element : freqMap.entrySet()) {
            Integer freq = element.getValue();
            if (freq % 2 != 0) {
                if (oddCheck) {
                    return false;
                }
                oddCheck = true;
            }
        }
        return true;
    }

    // O(n) time | O(1) space
    public boolean palindromeCheck2(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            count = count ^ c;
        }

        return count == 0 || (count >= 97 && count <= 122);
    }

    // Book

    // O(n) time | O(n) space (k space table)
    boolean isPermutationOfPalindrome(String phrase) {
        int[] table = buildFrequencyTable(phrase);
        return checkMaxOneOdd(table);
    }

    boolean checkMaxOneOdd(int[] table) {
        boolean foundOdd = false;
        for (int count : table) {
            if (count % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }

    int getCharNumber(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if (a <= val && val <= z) {
            return val - a;
        }
        return -1;
    }

    int[] buildFrequencyTable(String phrase) {
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                table[x]++;
            }
        }
        return table;
    }

    boolean isPermutationOfPalindrome2(String phrase) {
        int countOdd = 0;
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                table[x]++;
                if (table[x] % 2 == 1) {
                    countOdd++;
                } else {
                    countOdd--;
                }
            }
        }
        return countOdd <= 1;
    }

    int toggle(int bitVector, int index) {
        if (index < 0) {
            return bitVector;
        }
        int mask = 1 << index;
        bitVector ^= mask;
        return bitVector;
    }

    int createBitVector(String phrase) {
        int bitVector = 0;
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            bitVector = toggle(bitVector, x);
        }
        return bitVector;
    }

    boolean checkAtMostOneBitSet(int bitVector) {
        return (bitVector & (bitVector - 1)) == 0;
    }

    boolean isPermutationOfPalindrome3(String phrase) {
        int bitVector = createBitVector(phrase);
        return checkAtMostOneBitSet(bitVector);
    }

}
