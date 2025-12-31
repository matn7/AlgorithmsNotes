package december_2025;

public class Vector2D {

    private int[][] vec;
    private int row;
    private int col;

    public Vector2D(int[][] vec) {
        this.vec = vec;
        this.row = 0;
        this.col = 0;
    }

    public int next() {
        // Zwróć aktualny element
        int val = vec[row][col];
        col++;

        // Jeżeli skończymy przetwarzać bieżący wiersz, przechodzimy do następnego
        if (col == vec[row].length) {
            row++;
            col = 0;
        }
        return val;
    }

    public boolean hasNext() {
        // Sprawdzamy, czy są jeszcze elementy do przetworzenia
        while (row < vec.length && col == vec[row].length) {
            row++;
            col = 0;
        }
        return row < vec.length;
    }

}
