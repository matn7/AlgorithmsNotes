package udemy.recursion;

public class ReverseString {

    public static void main(String[] args) {
        String result = reverse("panda");
        System.out.println();
    }

    public static String reverse(String string) {
        if (string.length() == 0) {
            return "";
        }
        return reverse(string.substring(1)) + string.charAt(0);
    }

}
