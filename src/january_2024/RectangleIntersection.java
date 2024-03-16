package january_2024;

public class RectangleIntersection {

    public static void main(String[] args) {

        Rectangle a = new Rectangle(0, 0, 3, 2);
        Rectangle b = new Rectangle(1, 1, 3, 3);

        System.out.println(intersectRect(a, b).area());

    }

    // O(1) time | O(1) space
    public static Rectangle intersectRect(Rectangle a, Rectangle b) {
        return new Rectangle(Math.max(a.minX, b.minX), Math.max(a.minY, b.minY),
                Math.min(a.maxX, b.maxX), Math.min(a.maxY, b.maxY));
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

        public double area() {
            if (minX >= maxX) {
                return  0;
            }
            if (minY >= maxY) {
                return 0;
            }
            return (maxX - minX) * (maxY - minY);
        }
    }

}
