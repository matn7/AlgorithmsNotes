package udemy.faang.datastructuresalgorithms;

public class ReverseString {

    public static void main(String[] args) {
        String str = "Hi my name in Majka";
        ReverseString reverseString = new ReverseString();
//        String result = reverseString.reverse(str);
//        System.out.println();
        String result2 = reverseString.reverse2(str);
        System.out.println();
    }

    public String reverse(String str) {
        if (str.isEmpty()) {
            return "";
        }
        return reverse(str.substring(1)) + str.charAt(0);
    }

    public String reverse2(String str) {
        if (str.isEmpty() || str.length() < 2) {
            return "";
        }
        char[] strArr = str.toCharArray();
        int start = 0;
        int end = strArr.length - 1;
        while (start < end) {
            swap(strArr, start, end);
            start++;
            end--;
        }
        return String.valueOf(strArr);
    }

    private void swap(char[] strArr, int i, int j) {
        char temp = strArr[i];
        strArr[i] = strArr[j];
        strArr[j] = temp;
    }

}
