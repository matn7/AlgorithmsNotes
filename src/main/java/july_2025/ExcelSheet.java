package july_2025;

public class ExcelSheet {

    public static void main(String[] args) {
        String columnTitle = "ZY";

        ExcelSheet excelSheet = new ExcelSheet();
        int result = excelSheet.titleToNumber(columnTitle);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int titleToNumber(String columnTitle) {
        int sum = 0;
        int pow = 1;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            char c = columnTitle.charAt(i);

            int val = c - 'A' + 1;
            sum = sum + val * pow;
            pow *= 26;
        }
        return sum;
    }

}
