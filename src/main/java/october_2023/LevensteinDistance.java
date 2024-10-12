package october_2023;

public class LevensteinDistance {

    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "yabd";

        System.out.println(levensteinDistance(str1, str2));
    }

    // O(n*m) time | O(n*m) space
    public static int levensteinDistance(String str1, String str2) {
        if (str1.length() == 0 || str2.length() == 0) {
            return 0;
        }

        int[][] values = new int[str1.length() + 1][str2.length() + 1];

        for (int row = 0; row < values.length; row++) {
            values[row][0] = row;
        }
        for (int col = 0; col < values[0].length; col++) {
            values[0][col] = col;
        }

        //      ''  y   a   b   d
        //  ''  0   1   2   3   4
        //  a   1   1   1   2   3
        //  b   2   2   2   1   2
        //  c   3   3   3   2   2

        for (int row = 1; row < values.length; row++) {
            for (int col = 1; col < values[row].length; col++) {
                if (str1.charAt(row - 1) == str2.charAt(col - 1)) {
                    values[row][col] = values[row - 1][col - 1];
                } else {
                    values[row][col] = Math.min(values[row][col - 1],
                            Math.min(values[row - 1][col - 1], values[row - 1][col])) + 1;
                }
            }
        }

        return values[str1.length()][str2.length()];
    }

}
