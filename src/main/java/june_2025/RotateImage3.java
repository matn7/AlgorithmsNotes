package june_2025;

public class RotateImage3 {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        RotateImage3 rotateImage3 = new RotateImage3();
        rotateImage3.rotate(matrix);
        System.out.println();
    }

    public void rotate(int[][] matrix) {
        int l = 0;
        int r = matrix.length - 1;

        // top, l +i
        // bottom, r -i
        // alternate

        while (l < r) {
            int top = l;
            int bottom = r;

            for (int i = 0; i < r - l; i++) {
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
