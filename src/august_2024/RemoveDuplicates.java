package august_2024;

import july_2024.CoinChange;

import java.util.*;

public class RemoveDuplicates {

    public static void main(String[] args) {
        System.out.println(removeDup("hello"));

        System.out.println(removeDup("applep"));
        System.out.println(removeDup("aaaaaa"));
        System.out.println(removeDup("abc"));
    }

    public static String removeDup(String str) {
        Set<Character> set = new LinkedHashSet<>();
        for (char c : str.toCharArray()) {
            set.add(c);
        }
        StringBuilder builder = new StringBuilder();
        for (Character character : set) {
            builder.append(character);

        }
        return builder.toString();
    }

    public static String removeDup2(String str) {
        StringBuilder builder = new StringBuilder();
        for (Character character : str.toCharArray()) {
            if (!builder.toString().contains(String.valueOf(character))) {
                builder.append(character);
            }

        }
        return builder.toString();
    }


}
