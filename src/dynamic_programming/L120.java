package dynamic_programming;

import common.Utils;

import java.util.Collections;
import java.util.List;

public class L120 {

    public static void main(String[] args) {
//        String str = "[[2],[3,4],[6,5,7],[4,1,8,3]]";
        String str = "[[-10]]";
        List<List<Integer>> triangle = Utils.stringToInt2dList(str);
//        System.out.println(triangle);
        System.out.println(minimumTotal(triangle));
    }

//    给定一个三角形 triangle ，找出自顶向下的最小路径和
    public static int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        for(int i=1;i<m;i++) {
            List<Integer> row = triangle.get(i);
            int n = row.size();
//            每行的第0个位置，只能由上一行的第0个位置过来，所以他的路径和可以直接求出来
            row.set(0, triangle.get(i-1).get(0) + triangle.get(i).get(0));
            for(int j=1;j<n;j++) {
//                直接在源数据上改，不额外占用空间
                if(j == n-1) {
                    row.set(j, triangle.get(i-1).get(j-1) + triangle.get(i).get(j));
                } else {
                    row.set(j, Math.min(triangle.get(i-1).get(j-1), triangle.get(i-1).get(j)) + triangle.get(i).get(j));
                }
            }
        }
//        把每个位置的最小路径和都求出来了。再遍历一下最后一行就可以了
        List<Integer> lastRow = triangle.get(m-1);
        return Collections.min(lastRow);
    }
}
