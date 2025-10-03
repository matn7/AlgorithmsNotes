package september_2025;

public class ExcelSheetColumn {

    // O(log(n)) time | O(1) space
    public String convertToTitle(int columnNumber) {
        StringBuilder res = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            int offset = columnNumber % 26;
            res.append((char) ('A' + offset));
            columnNumber /= 26;
        }
        return res.reverse().toString();
    }

}
