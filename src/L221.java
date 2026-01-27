


import jdk.jshell.execution.Util;

public class L221 {

    public static void main(String[] args) {
        String s = "[[\"1\",\"0\",\"1\",\"0\",\"0\"],[\"1\",\"0\",\"1\",\"1\",\"1\"],[\"1\",\"1\",\"1\",\"1\",\"1\"],[\"1\",\"0\",\"0\",\"1\",\"0\"]]";

//        String s = "[[\"0\",\"1\"],[\"1\",\"0\"]]";

//        String s = "[[\"1\",\"1\",\"1\",\"1\",\"0\"],[\"1\",\"1\",\"1\",\"1\",\"0\"],[\"1\",\"1\",\"1\",\"1\",\"1\"],[\"1\",\"1\",\"1\",\"1\",\"1\"],[\"0\",\"0\",\"1\",\"1\",\"1\"]]";

//        String s = "[[\"0\",\"0\",\"0\",\"1\"],[\"1\",\"1\",\"0\",\"1\"],[\"1\",\"1\",\"1\",\"1\"],[\"0\",\"1\",\"1\",\"1\"],[\"0\",\"1\",\"1\",\"1\"]]";

        char[][] matrix = Utils.stringToChar2dArray(s);
//        for(int i=0;i<matrix.length;i++) {
//            for(int j=0;j<matrix[i].length;j++) {
//                System.out.print(matrix[i][j]);
//            }
//            System.out.println("--------------");
//        }
        System.out.println(maximalSquare(matrix));
    }


//    用动态规划，借助之前的格子的计算结果来算
    public static int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0; // 最大的正方形的边长
        //f[i][j] 以i，j这个位置为右下角能形成的正方形的最大边长
        int[][] f = new int[m][n];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(matrix[i][j] == '1') {
                    if(i == 0 || j ==0) {
                        f[i][j] = 1;
                    } else {
                        f[i][j] = Math.min(Math.min(f[i-1][j], f[i-1][j-1]), f[i][j-1])+1;
                    }
                    max = Math.max(max, f[i][j]);
                }
            }
        }
        return max*max;
    }


////    在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积
////    先试试暴力法能不能过
////    暴力法求解结果是没问题的，就是时间太长了。
//    public static int maximalSquare(char[][] matrix) {
//        int max = 0;
//        int m = matrix.length;
//        int n = matrix[0].length;
//        for(int i=0;i<m;i++) {
//            for(int j=0;j<n;j++) {
//                max = Math.max(max, findMax(i,j,matrix));
//            }
//        }
//        return max;
//    }
//
//    private static int findMax(int row, int col, char[][] matrix) {
//        if(matrix[row][col] == '0') {
//            return 0;
//        }
//        int max = 1;
//        int i = row;
//        int j = col;
//        int level = 1;
//        while(true) {
//            i = row+level;
//            j = col+level;
//            if(i >= matrix.length || j >= matrix[0].length) {
//                break;
//            }
//            // 从【i，col】=》【i，j】 和 从【row，j】=》【i，j】 这里面的格子都必须是1才能继续
//            for(int y = col;y<=j;y++ ) {
//                if(matrix[i][y] == '0') {
//                    return max;
//                }
//            }
//            for(int x = row;x<=i;x++) {
//                if (matrix[x][j] == '0') {
//                    return max;
//                }
//            }
//            max = (level+1) * (level+1);
//            level++;
//        }
//        return max;
//    }
}
