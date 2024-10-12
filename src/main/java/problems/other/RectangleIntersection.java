package problems.other;

public class RectangleIntersection {

    public static void main(String[] args) {

        Rectangle a = new Rectangle(0,0, 3, 2);
        Rectangle b = new Rectangle(1, 1, 3, 3);

        // O(1) time | O(1) space
        Rectangle intersection = new Rectangle();
        Rectangle rectangle = intersection.intersect_rect(a, b);
        double result = rectangle.area();
        System.out.println(result);
    }

    // O(1) time | O(1) space
    public int intersection(int[][] green, int[][] blue) {
        int[] gX = {Integer.MAX_VALUE, Integer.MIN_VALUE};
        int[] gY = {Integer.MAX_VALUE, Integer.MIN_VALUE};

        int[] bX = {Integer.MAX_VALUE, Integer.MIN_VALUE};
        int[] bY = {Integer.MAX_VALUE, Integer.MIN_VALUE};

        getRanges(green, gX, gY);
        getRanges(blue, bX, bY);

        int[] commonX = {Math.max(gX[0], bX[0]), Math.min(gX[1], bX[1])};
        int[] commonY = {Math.max(gY[0], bY[0]), Math.min(gY[1], bY[1])};

        int xVal = Math.abs(commonX[1] - commonX[0]);
        int yVal = Math.abs(commonY[1] - commonY[0]);
        return xVal * yVal;
    }

    private void getRanges(int[][] coords, int[] cX, int[] cY) {
        for (int[] c : coords) {
            cX[0] = Math.min(cX[0], c[0]);
            cX[1] = Math.max(cX[1], c[0]);

            cY[0] = Math.min(cY[0], c[1]);
            cY[1] = Math.max(cY[1], c[1]);
        }
    }

}

class Rectangle {
    int min_x;
    int min_y;
    int max_x;
    int max_y;

    public Rectangle() {
    }

    public Rectangle(int min_x, int min_y, int max_x, int max_y) {
        this.min_x = min_x;
        this.min_y = min_y;
        this.max_x = max_x;
        this.max_y = max_y;
    }

    public double area() {
        if (min_x >= max_x) {
            return 0;
        }
        if (min_y >= max_y) {
            return 0;
        }
        return (max_x - min_x) * (max_y - min_y);
    }

    public Rectangle intersect_rect(Rectangle a, Rectangle b) {
        Rectangle rectangle = new Rectangle(
                Math.max(a.min_x, b.min_x),
                Math.max(a.min_y, b.min_y),
                Math.min(a.max_x, b.max_x),
                Math.min(a.max_y, b.max_y));
        return rectangle;
    }
}
