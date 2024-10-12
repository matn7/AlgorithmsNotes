package udemy.recursion;

public class PaintFill {

    public static void main(String[] args) {
        String[][] board = {
                {"0", "0", "0", "0", "0"},
                {"0", "0", "1", "1", "2"},
                {"0", "1", "1", "1", "2"},
                {"0", "1", "2", "2", "2"},
                {"0", "0", "0", "0", "0"}, // 4
                {"0", "0", "0", "0", "0"}, // 5
        };

        Pixel[][] pixelBoard = new Pixel[board.length][board[0].length];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                pixelBoard[row][col] = new Pixel(board[row][col]);
            }
        }

        paintFill(pixelBoard, 1, 2, "5");

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(pixelBoard[row][col].getColor() + " ");
            }
            System.out.println();
        }

        paintFill(pixelBoard, 0, 0, "8");
        System.out.println("--------------");
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(pixelBoard[row][col].getColor() + " ");
            }
            System.out.println();
        }

        System.out.println();

    }

    // O(n) time
    public static Pixel[][] paintFill(Pixel[][] board, int x, int y, String newColor) {
        String coordColor = board[x][y].getColor();
        fill(board, x, y, coordColor, newColor);
        return board;
    }

    private static void fill(Pixel[][] board, int x, int y, String coordColor, String newColor) {
        if (x < 0 || x > board.length - 1 || y < 0 || y > board[x].length - 1) {
            return;
        }
        String currColor = board[x][y].getColor();
        if (currColor.equals(coordColor)) {
            board[x][y].setColor(newColor);
            fill(board, x - 1, y, coordColor, newColor);
            fill(board, x + 1, y, coordColor, newColor);
            fill(board, x, y - 1, coordColor, newColor);
            fill(board, x, y + 1, coordColor, newColor);
        }
    }

    public static class Pixel {
        private String color;

        public Pixel(String color) {
            this.color = color;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }
    }

}
