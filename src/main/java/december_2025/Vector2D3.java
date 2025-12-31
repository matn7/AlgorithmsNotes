package december_2025;

public class Vector2D3 {

    int[][] vec;
    int row = 0;
    int col = 0;

    public Vector2D3(int[][] vec) {
        this.vec = vec;
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
