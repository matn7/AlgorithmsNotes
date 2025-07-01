package june_2025;

public class Rotate {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        Rotate rotate = new Rotate();
        rotate.rotate(matrix);
        System.out.println();
    }

    // O(n^2) time | O(1) space
    public void rotate(int[][] matrix) {
        // l, top +i
        // r, bottom -i
        // topLeft = matrix[top][l + i]

        // TL   TR
        // BL   BR
        int l = 0;
        int r = matrix.length - 1;
        while (l < r) {
            for (int i = 0; i < r - l; i++) {
                int top = l;
                int bottom = r;
                int topLeft = matrix[top][l + i];
                matrix[top][l + i] = matrix[bottom - i][l];
                matrix[bottom - i][l] = matrix[bottom][r - i];
                matrix[bottom][r - i] = matrix[top + i][r];
                matrix[top + i][r] = topLeft;
            }
            l++;
            r--;
        }

    }
}