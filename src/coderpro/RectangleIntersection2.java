package coderpro;

public class RectangleIntersection2 {

    public static void main(String[] args) {
        int[][] green = {{0,0}, {0,2}, {3,2}, {3,0}};
        int[][] blue = {{1,1}, {1,3}, {3,3}, {3,1}};


        RectangleIntersection2 rectangleIntersection2 = new RectangleIntersection2();
        int result = rectangleIntersection2.intersection(green, blue);
        System.out.println(result);
    }

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
