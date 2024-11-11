package november_2024;

public class ZigZag2 {

    public static void main(String[] args) {
        ZigZag2 zigZag = new ZigZag2();

        String s = "PAYPALISHIRING";
        int numRows = 3;
        String convert = zigZag.convert(s, numRows);
        System.out.println(convert);
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder res = new StringBuilder();

        for (int r = 0; r < numRows; r++) {
            int increment = 2 * (numRows - 1);
            for (int i = r; i < s.length(); i += increment) {
                res.append(s.charAt(i));
                if (r > 0 && r < numRows - 1 && i + increment - 2 * r < s.length()) {
                    res.append(s.charAt(i + increment - 2 * r));
                }
            }
        }
        return res.toString();
    }

}
