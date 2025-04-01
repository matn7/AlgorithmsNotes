package march_2025;

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

        int L = 0;
        int R = matrix[0].length - 1;

        while (L < R) {
            for (int i = 0; i < R - L; i++) {
                int top = L;
                int bottom = R;

                int temp = matrix[top][L + i];

                matrix[top][L + i] = matrix[bottom - i][L];

                matrix[bottom - i][L] = matrix[bottom][R - i];

                matrix[bottom][R - i] = matrix[top + i][R];

                matrix[top + i][R] = temp;
            }

            L++;
            R--;
        }
    }

}
