package dynamic_programming;

public class L62 {

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
    }

    /**
     * 有m行，n列
     * 机器人每次只能向下或者向右移动一步
     * 二维动态规划
     * 这只是找出有多少种路径，接下去就是对路径加上各种限制，求对应的路径数量
     */
    public static int uniquePaths(int m, int n) {
//        f记录到达某个位置的路径数
        int[][] f = new int[m][n];
//        从上往下，从左往右，计算”后面“的时候，他”前面“的已经计算出来了
//        f[i][j] = f[i-1][j] + f[i][j-1];

//        第一行上的点，只能是从左边过来，所以都是1
        for(int i=0;i<n;i++) {
            f[0][i] = 1;
        }
//        第一列的点也同样的道理
        for(int i=0;i<m;i++) {
            f[i][0] = 1;
        }
        for(int i=1;i<m;i++) {
            for(int j=1;j<n;j++) {
                f[i][j] = f[i-1][j] + f[i][j-1];
            }
        }

        return f[m-1][n-1];//最后要到达的位置
    }
}
