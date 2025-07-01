package june_2025;

public class RotateImage2 {

    // O(n) time | O(1) space
    public void rotate(int[][] matrix) {
        int l = 0;
        int r = matrix.length - 1;
        // top, l +i
        // bottom, r -i
        while (l < r) {
            int top = l;
            int bottom = r;
            for (int i = 0; i < (r - l); i++) {
                int tl = matrix[top][l + i];
                matrix[top][l + 1] = matrix[bottom - i][l];
                matrix[bottom - i][l] = matrix[bottom][r - i];
                matrix[bottom][r - i] = matrix[top + i][r];
                matrix[top + i][r] = tl;
            }
            l++;
            r--;
        }
    }

}
