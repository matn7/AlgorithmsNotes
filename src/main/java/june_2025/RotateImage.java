package june_2025;

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

    public void rotate(int[][] matrix) {

        // tl
        // top, left +i
        // bottom, right -i
        int l = 0;
        int r = matrix[0].length - 1;

        while (l < r) {
            int top = l;
            int bottom = r;
            for (int i = 0; i < r - l; i++) {
                int tl = matrix[top][l + i];
                matrix[top][l + i] = matrix[bottom - i][l];
                matrix[bottom - i][l] = matrix[bottom][r - i];
                matrix[bottom][r - i] = matrix[top + i][r];
                matrix[top + i][r] = tl;
            }
            r--;
            l++;
        }

    }


}
