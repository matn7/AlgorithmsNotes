package november_2024;

public class LengthOfLastWord {

    public static void main(String[] args) {
        String s = "fly me   to   the moon         ";
        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
        int result = lengthOfLastWord.lengthOfLastWord(s);
        System.out.println(result);
    }

    public int lengthOfLastWord(String s) {
        int lastIdx = s.length() - 1;

        while (lastIdx >= 0 && s.charAt(lastIdx) == ' ') {
            lastIdx--;
        }

        int size = 0;
        while (lastIdx >= 0 && s.charAt(lastIdx) != ' ') {
            size++;
            lastIdx--;
        }
        return size;
    }

}
