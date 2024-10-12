package udemy.generalprogramming;

import java.util.ArrayList;
import java.util.List;

public class PointsWithinDistance {

    public static List<Point> getPointsWithDistance(List<Point> list, Point point, double distance) {
        List<Point> withinDistanceList = new ArrayList<>();
        for (Point p : list) {
            if (p.isWithinDistance(point, distance)) {
                withinDistanceList.add(p);
            }
        }

        return withinDistanceList;
    }

    public static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        // helper method to calculate distance from another point
        public double getDistance(Point otherPoint) {
            return Math.sqrt(Math.pow(otherPoint.x - x, 2) + Math.pow(otherPoint.y - y, 2));
        }

        // if the point exceed distance on any one of axis, it means it will not be in range
        public boolean isWithinDistance(Point otherPoint, double distance) {
            if (Math.abs(otherPoint.x - x) > distance || (otherPoint.y - y) > distance) {
                return false;
            }

            return getDistance(otherPoint) <= distance;
        }
    }

}
