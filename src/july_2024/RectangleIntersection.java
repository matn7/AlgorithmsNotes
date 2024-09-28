package july_2024;

public class RectangleIntersection {
    int min_x;
    int min_y;
    int max_x;
    int max_y;

    public RectangleIntersection() {}

    public RectangleIntersection(int min_x, int min_y, int max_x, int max_y) {
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

    public RectangleIntersection intersectRectangle(RectangleIntersection a, RectangleIntersection b) {
        RectangleIntersection rect = new RectangleIntersection(
                Math.max(a.min_x, b.min_x),
                Math.max(a.min_y, b.min_y),
                Math.min(a.max_x, b.max_x),
                Math.min(a.max_y, b.max_y)
        );
        return rect;
    }
}
