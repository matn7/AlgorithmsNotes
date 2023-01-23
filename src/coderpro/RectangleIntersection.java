package coderpro;

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
