package star;

public class Main {

    public static void main(String[] args) {
        String[] words = {"dog", "door", "dark", "cat", "elephant", "dodge"};
        Autocompletion autocompletion = new Autocompletion(words);

        autocompletion.autocompletion("do");
    }

}
