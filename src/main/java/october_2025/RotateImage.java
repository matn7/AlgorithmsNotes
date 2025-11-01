package october_2025;

public class RotateImage {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        RotateImage rotateImage = new RotateImage();
        rotateImage.rotate(matrix);
        System.out.println();
    }

    // O(n^2) time | O(1) space
    public void rotate(int[][] matrix) {
        int l = 0;
        int r = matrix.length - 1;

        // l, top ++
        // r, bottom --

        while (l < r) {
            int top = l;
            int bottom = r;
            for (int i = 0; i < r - l; i++) {
                int topLeft = matrix[top + i][l];
                // top left = bottom left
                matrix[top + i][l] = matrix[bottom][l + i]; // 1 -> 7

                // bottom left = bottom right
                matrix[bottom][l + i] = matrix[bottom - i][r]; // 7 -> 9

                // bottom right = top right
                matrix[bottom - i][r] = matrix[top][r - i]; // 9 -> 3

                // top right = top left
                matrix[top][r - i] = topLeft; // 3 -> 1
            }
            l++;
            r--;
        }
    }

}
