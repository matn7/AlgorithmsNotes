package medium;


public class OneEdit {

    // ********
    // * STAR *
    // ********

    // O(n + m) time | O(n + m) space
    public boolean oneEdit(String stringOne, String stringTwo) {
        // Write your code here.
        int lengthOne = stringOne.length();
        int lengthTwo = stringTwo.length();
        if (Math.abs(lengthOne - lengthTwo) > 1) {
            return false;
        }

        int min = Math.min(lengthOne, lengthTwo);

        for (int i = 0; i < min; i++) {
            if (stringOne.charAt(i) != stringTwo.charAt(i)) {
                if (lengthOne > lengthTwo) {
                    return stringOne.substring(i + 1).equals(stringTwo.substring(i));
                } else if (lengthTwo > lengthOne) {
                    return stringOne.substring(i).equals(stringTwo.substring(i + 1));
                } else {
                    return stringOne.substring(i + 1).equals(stringTwo.substring(i + 1));
                }
            }
        }
        return true;
    }

    // O(min(n,m)) time | O(1) space
    public boolean oneEdit2(String stringOne, String stringTwo) {
        // Write your code here.
        int lengthOne = stringOne.length();
        int lengthTwo = stringTwo.length();
        if (Math.abs(lengthOne - lengthTwo) > 1) {
            return false;
        }
        boolean madeEdit = false;
        int indexOne = 0;
        int indexTwo = 0;

        while (indexOne < lengthOne && indexTwo < lengthTwo) {
            if (stringOne.charAt(indexOne) != stringTwo.charAt(indexTwo)) {
                if (madeEdit) {
                    return false;
                }
                madeEdit = true;

                if (lengthOne > lengthTwo) {
                    indexOne++;
                } else if (lengthTwo > lengthOne) {
                    indexTwo++;
                } else {
                    indexOne++;
                    indexTwo++;
                }
            } else {
                indexOne++;
                indexTwo++;
            }
        }
        return true;
    }

}
