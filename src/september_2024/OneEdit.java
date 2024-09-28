package september_2024;

public class OneEdit {

    public static void main(String[] args) {
        String str1 = "apple";
        String str2 = "aple";

        OneEdit oneEdit = new OneEdit();
        boolean result = oneEdit.oneEdit(str1, str2);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public boolean oneEdit(String str1, String str2) {
        if (Math.abs(str1.length() - str2.length()) > 1) {
            return false;
        }
        int p1 = 0;
        int p2 = 0;
        boolean modifyUsed = false;

        while (p1 < str1.length() || p2 < str2.length()) {
            Character one = null;
            if (p1 < str1.length()) {
                one = str1.charAt(p1);
            }
            Character two = null;
            if (p2 < str2.length()) {
                two = str2.charAt(p2);
            }

            if (one != two) {
                if (modifyUsed) {
                    return false;
                }
                modifyUsed = true;
                if (str1.length() > str2.length()) {
                    p1++;
                } else if (str1.length() < str2.length()) {
                    p2++;
                } else {
                    p1++;
                    p2++;
                }
            } else {
                p1++;
                p2++;
            }

        }
        return true;
    }

    // Book

    // O(n) time | O(1) space
    boolean onEditAway(String first, String second) {
        if (first.length() == second.length()) {
            return oneEditReplace(first, second);
        } else if (first.length() + 1 == second.length()) {
            return oneEditInsert(first, second);
        } else if (first.length() - 1 == second.length()) {
            return oneEditInsert(second, first);
        }
        return false;
    }

    boolean oneEditReplace(String s1, String s2) {
        boolean foundDifferences = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (foundDifferences) {
                    return false;
                }
                foundDifferences = true;
            }
        }
        return true;
    }

    boolean oneEditInsert(String s1, String s2) {
        int index1 = 0;
        int index2 = 0;
        while (index2 < s2.length() && index1 < s1.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (index1 != index2) {
                    return false;
                }
                index2++;
            } else {
                index1++;
                index2++;
            }
        }
        return true;
    }

    boolean oneEditAway2(String first, String second) {
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }

        String s1 = first.length() < second.length() ? first : second;
        String s2 = first.length() < second.length() ? second : first;

        int index1 = 0;
        int index2 = 0;
        boolean foundDifferences = false;

        while (index2 < s2.length() && index1 < s1.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (foundDifferences) {
                    return false;
                }
                foundDifferences = true;

                if (s1.length() == s2.length()) {
                    index1++;
                }
            } else {
                index1++;
            }
            index2++;
        }
        return true;
    }

}
