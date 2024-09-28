package problems.other;

public class WordSearch {

    public static void main(String[] args) {
        char[][] matrix = {
                {'F', 'A', 'C', 'I'},
                {'O', 'B', 'Q', 'P'},
                {'A', 'N', 'O', 'B'},
                {'M', 'A', 'S', 'S'}
        };
        String word = "XYZ";
        Grid grid = new Grid(matrix);
        boolean result = grid.wordSearch(word);
        System.out.println(result);
    }


}

class Grid {
    char[][] matrix;

    public Grid(char[][] matrix) {
        this.matrix = matrix;
    }

    // O(m*n) time | O(1) space
    public boolean wordSearch(String word) {
        for (int i = 0; i < matrix.length; i++) {
            if (wordSearchRight(i, word)) {
                return true;
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if (wordSearchBottom(i, word)) {
                return true;
            }
        }
        return false;
    }

    private boolean wordSearchRight(int index, String word) {
        for (int i = 0; i < matrix[index].length; i++) {
            if (word.charAt(i) != matrix[index][i]) {
                return false;
            }
        }
        return true;
    }

    private boolean wordSearchBottom(int index, String word) {
        for (int i = 0; i < matrix.length; i++) {
            if (word.charAt(i) != matrix[i][index]) {
                return false;
            }
        }
        return true;
    }
}
