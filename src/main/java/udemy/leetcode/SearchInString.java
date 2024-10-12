package udemy.leetcode;

public class SearchInString {

    public static void main(String[] args) {
        // Q1: Find the character element in the string
        String name = "Samuel";
        char target = 'u';
        SearchInString searchInString = new SearchInString();
        System.out.println(searchInString.linearSearch2(name, target));
    }

    public boolean linearSearch2(String name, char target) {
        if (name.length() == 0) {
            return false;
        }
        for (int index = 0; index < name.length(); index++) {
            if (name.charAt(index) == target) {
                return true;
            }
        }
        return false;
    }

}
