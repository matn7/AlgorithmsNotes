package udemy.generalprogramming;

public class Encoding {

    // "ABBCCC" will be encoded: "1A2B3C"
    // "AABBBCCCC" will be encoded as "2A3B4C"
    // "1D2E1F" will be decoded as "DEEF"
    public static String encode(String originalString) {
        // a null string is encoded as null
        if (originalString == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        // start at index 0 and read the string character by character
        int currIndex = 0;
        // walk the string, ensuring that you stay within bounds
        while (currIndex < originalString.length()) {
            char currChar = originalString.charAt(currIndex);

            int num = 0;
            int compareIndex = currIndex;
            // compare the current character to all characters following it to see if it is the same
            while (compareIndex < originalString.length() && currChar == originalString.charAt(compareIndex)) {
                compareIndex++;
                // num keeps track of how many times the character is repeated
                num++;
            }
            // append the number of times the character appears in the run and the character itself
            sb.append(num);
            sb.append(currChar);

            // move to the next character after the current run
            currIndex = compareIndex;
        }

        return sb.toString();
    }

    // 1a22b1c will be decoded as "abbbbbbbbbbbbbbbbbbbbbbc
    public static String decode(String encodedString) {
        // a null string is decoded as null
        if (encodedString == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        // the encoded string will have a number followed by the character which is repeated that number of times
        int numStartIndex = 0;
        int numEndIndex = 1;
        while (numEndIndex < encodedString.length()) {
            // the digits of the number are characters in the string and these indices keep track of how many characters
            // the number occupies, the number can be `> 9` which means it occupies more than one character position
            while (Character.isDigit(encodedString.charAt(numEndIndex))) {
                numEndIndex++;
            }

            // the character is present at this position, after the number denoting how often the character is repeated
            int charIndex = numEndIndex;
            String numString = encodedString.substring(numStartIndex, numEndIndex);
            int num = Integer.valueOf(numString);
            for (int i = 0; i < num; i++) {
                // append the character to the decoded string, as many times as the encoding specified
                sb.append(encodedString.charAt(charIndex));
            }
            // move to the next number + character which has to be decoded
            numStartIndex = charIndex + 1;
            numEndIndex = numStartIndex + 1;
        }

        return sb.toString();
    }


}
