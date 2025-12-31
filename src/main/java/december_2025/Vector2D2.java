package december_2025;

public class Vector2D2 {

    public static void main(String[] args) {
//        int[][] vec = {
//                {1, 2},
//                {3},
//                {4}
//        };

        int[][] vec = {
                new int[] {},
                {}
        };

        Vector2D2 vector2D2 = new Vector2D2(vec);
//        System.out.println(vector2D2.next());
//        System.out.println(vector2D2.next());
//        System.out.println(vector2D2.next());
//        System.out.println(vector2D2.hasNext());
//        System.out.println(vector2D2.hasNext());
//        System.out.println(vector2D2.next());
        System.out.println(vector2D2.hasNext());
    }

    int row;
    int col;
    int[][] vec;

    public Vector2D2(int[][] vec) {
        this.vec = vec;
    }

    public int next() {
        int res = vec[row][col];
        col++;

        if (col == vec[row].length) {
            row++;
            col = 0;
        }
        return res;
    }

    public boolean hasNext() {
        while (row < vec.length && col == vec[row].length) {
            row++;
            col = 0;
        }
        return row < vec.length;
    }

}
