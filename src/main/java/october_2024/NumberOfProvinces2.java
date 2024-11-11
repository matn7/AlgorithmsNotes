package october_2024;

import java.util.*;

public class NumberOfProvinces2 {

    public static void main(String[] args) {
        int[][] isConnected = {{1,0,0}, {0,1,0}, {0,0,1}};

        NumberOfProvinces2 numberOfProvinces = new NumberOfProvinces2();
        int circleNum = numberOfProvinces.findCircleNum(isConnected);
        System.out.println(circleNum);
    }


    // leetcode 547

    // O(v + e) time | O(v) space
    public int findCircleNum(int[][] isConnected) {
        return 0;
    }


}
