package september_2024;

public class URLify {

    public static void main(String[] args) {
        String str = "      Mr John     Smith     ";
        int k = 17;

        URLify urLify = new URLify();
        String result = urLify.urlify(str, k);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public String urlify(String input, int k) {
        if (input.length() == 0) {
            return input;
        }
        int start = 0;
        int end = input.length() - 1;
        while (start < input.length() && input.charAt(start) == ' ') {
            start++;
        }
        while (end >= 0 && input.charAt(end) == ' ') {
            end--;
        }
        char[] chars = new char[k];
        int counter = 0;
        for (int i = start; i <= end; i++) {
            if (input.charAt(i) == ' ') {
                chars[counter] = '#';
            } else {
                chars[counter] = input.charAt(i);
            }
            counter++;
        }
        StringBuilder builder = new StringBuilder();
        for (char c : chars) {
            if (c == '#') {
                builder.append("%20");
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }

    // Book

    void replaceSpaces(char[] str, int trueLength) {
        int numberOfSpaces = countOfChar(str, 0, trueLength, ' ');
        int newIndex = trueLength - 1 + numberOfSpaces * 2;

        if (newIndex + 1 < str.length) {
            str[newIndex + 1] = '\0';
        }
        for (int oldIndex = trueLength - 1; oldIndex >= 0; oldIndex--) {
            if (str[oldIndex] == ' ') {
                str[newIndex] = '0';
                str[newIndex - 1] = '2';
                str[newIndex - 2] = '%';
                newIndex -= 3;
            } else {
                str[newIndex] = str[oldIndex];
                newIndex -= 1;
            }
        }
    }

    int countOfChar(char[] str, int start, int end, int target) {
        int count = 0;
        for (int i = start; i < end; i++) {
            if (str[i] == target) {
                count++;
            }
        }
        return count;
    }

}
