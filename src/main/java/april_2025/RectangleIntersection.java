package april_2025;

public class RectangleIntersection {

    public static void main(String[] args) {
        Rectangle a = new Rectangle(0, 0, 3, 2);
        Rectangle b = new Rectangle(1, 1, 3, 3);
        RectangleIntersection rectangleIntersection = new RectangleIntersection();

        Rectangle c = rectangleIntersection.intersectRect(a, b);
        System.out.println(c.area());
    }

    // O(1) time | O(1) space
    public Rectangle intersectRect(Rectangle a, Rectangle b) {
        return new Rectangle(Math.max(a.min_x, b.min_x), Math.max(a.min_y, b.min_y), Math.min(a.max_x, b.max_x), Math.min(a.max_y, b.max_y));
    }

    static class Rectangle {
        int min_x;
        int min_y;
        int max_x;
        int max_y;
        public Rectangle(int min_x, int min_y, int max_x, int max_y) {
            this.min_x = min_x;
            this.min_y = min_y;
            this.max_x = max_x;
            this.max_y = max_y;
        }

        public int area() {
            if (min_x > max_x) {
                return 0;
            }
            if (min_y > max_y) {
                return 0;
            }
            return (max_x - min_x) * (max_y - min_y);
        }
    }
}
