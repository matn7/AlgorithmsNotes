package january_2026;

public class RectangleArea {

    // O(1) time | O(1) space
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        Rectangle a = new Rectangle(ax1, ay1, ax2, ay2);
        Rectangle b = new Rectangle(bx1, by1, bx2, by2);

        Rectangle c = intersect(a, b);
        return a.area() + b.area() - c.area();
    }

    private Rectangle intersect(Rectangle a, Rectangle b) {
        return new Rectangle(Math.max(a.minX, b.minX), Math.max(a.minY, b.minY), Math.min(a.maxX, b.maxX), Math.min(a.maxY, b.maxY));
    }

    static class Rectangle {
        int minX;
        int minY;
        int maxX;
        int maxY;

        public Rectangle(int minX, int minY, int maxX, int maxY) {
            this.minX = minX;
            this.minY = minY;
            this.maxX = maxX;
            this.maxY = maxY;
        }

        public int area() {
            if (minX >= maxX) {
                return 0;
            }
            if (minY >= maxY) {
                return 0;
            }
            return (maxX - minX) * (maxY - minY);
        }
    }

}
