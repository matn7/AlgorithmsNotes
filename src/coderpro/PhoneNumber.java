package coderpro;

import java.util.*;

public class PhoneNumber {

    static Map<Character, List<String>> keyMap = new HashMap<>();

    static {
        keyMap.put('1', new ArrayList<>(Arrays.asList("1")));
        keyMap.put('2', new ArrayList<>(Arrays.asList("A", "B", "C")));
        keyMap.put('3', new ArrayList<>(Arrays.asList("D", "E", "F")));
        keyMap.put('4', new ArrayList<>(Arrays.asList("G", "H", "I")));
        keyMap.put('5', new ArrayList<>(Arrays.asList("J", "K", "L")));
        keyMap.put('6', new ArrayList<>(Arrays.asList("M", "N", "O")));
        keyMap.put('7', new ArrayList<>(Arrays.asList("P", "Q", "R", "S")));
        keyMap.put('8', new ArrayList<>(Arrays.asList("T", "U", "V")));
        keyMap.put('9', new ArrayList<>(Arrays.asList("W", "X", "Y", "Z")));
        keyMap.put('0', new ArrayList<>(Arrays.asList("0")));
    }

    static Map<Integer, List<String>> lettersMap = new HashMap<>();

    static List<String> validWords = new ArrayList<>();

    static {
        lettersMap.put(1, new ArrayList<>(Arrays.asList("1")));
        lettersMap.put(2, new ArrayList<>(Arrays.asList("A", "B", "C")));
        lettersMap.put(3, new ArrayList<>(Arrays.asList("D", "E", "F")));
        lettersMap.put(4, new ArrayList<>(Arrays.asList("G", "H", "I")));
        lettersMap.put(5, new ArrayList<>(Arrays.asList("J", "K", "L")));
        lettersMap.put(6, new ArrayList<>(Arrays.asList("M", "N", "O")));
        lettersMap.put(7, new ArrayList<>(Arrays.asList("P", "Q", "R", "S")));
        lettersMap.put(8, new ArrayList<>(Arrays.asList("T", "U", "V")));
        lettersMap.put(9, new ArrayList<>(Arrays.asList("W", "X", "Y", "Z")));
        lettersMap.put(0, new ArrayList<>(Arrays.asList("0")));

        validWords.add("DOG");
        validWords.add("FISH");
        validWords.add("CAT");
        validWords.add("FOG");
    }

    public static void main(String[] args) {

        String[] listOfWords = new String[] {"DOG", "CAT", "FISH", "FOG"};

        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.phoneNumber("364", listOfWords);

        List<String> result = phoneNumber.makeWords("364");
        System.out.println();
    }

    public List<String> makeWords(String phone) {
        List<Integer> digits = new ArrayList<>();
        for (Character p : phone.toCharArray()) {
            digits.add(Integer.parseInt(String.valueOf(p)));
        }
        List<String> result = new ArrayList<>();

        make_words_helper(digits, new ArrayList<>(), result);

        return result;
    }

    private void make_words_helper(List<Integer> digits, List<String> letters, List<String> result) {
        if (digits.isEmpty()) {
            StringBuilder word = new StringBuilder();
            for (String letter : letters) {
                word.append(letter);
            }
            String w = word.toString();
            if (validWords.contains(w)) {
                result.add(w);
            }
            return;
        }

        List<String> chars = lettersMap.get(digits.get(0));
        for (String c : chars) {
            List<String> newLetters = new ArrayList<>(letters);
            newLetters.add(c);
            make_words_helper(digits.subList(1, digits.size() - 1), newLetters, result);
        }
    }

    // O(k^n) time | O(k) space (k is number of digits in number)
    public List<String> phoneNumber(String number, String[] listOfWords) {
        List<String> allMnemonics = new ArrayList<>();
        phoneNumberHelper(number, 0, number.length(), "", allMnemonics);
        List<String> result = new ArrayList<>();
        for (String word : listOfWords) {
            if (allMnemonics.contains(word)) {
                result.add(word);
            }
        }
        return result;
    }

    // rec(364, 0, 3)

    private void phoneNumberHelper(String number, int index, int end, String mnemonic, List<String> result) {
        if (index == end) {
            result.add(mnemonic);
            return;
        }
        char numChar = number.charAt(index);
        List<String> chars = keyMap.get(numChar);
        for (String c : chars) {
            String newMnemo = mnemonic + c;
            phoneNumberHelper(number, index + 1, end, newMnemo, result);
        }
    }

}
