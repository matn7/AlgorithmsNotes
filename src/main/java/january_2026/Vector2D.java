package january_2026;

public class Vector2D {

    int[][] vec;
    int row;
    int col;
    public Vector2D(int[][] vec) {
        this.vec = vec;
        this.row = 0;
        this.col = 0;
    }

    public int next() {
        int val = vec[row][col];
        col++;
        if (col == vec[row].length) {
            row++;
            col = 0;
        }
        return val;
    }

    public boolean hasNext() {
        while (row < vec.length && col == vec[row].length) {
            row++;
            col = 0;
        }
        return row < vec.length;
    }

}
