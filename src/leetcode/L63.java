package leetcode;


public class L63 {

    public static void main(String[] args) {
//        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        int[][] obstacleGrid = {{0,1}, {0,0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }

//    1 <= m, n <= 100
//机器人每次只能向下或者向右移动一步
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) {
//            在起点或者终点放着障碍，就一条路径都没有了
            return 0;
        }
//        f[i][j] = f[i-1][j] + f[i][j-1]
//        路径上有障碍，==1，就没有路径
        // 构建数组时，数组的长度有时候是m*n方便，有时候是m+1 * n+1 方便。不是一定是哪一个
        int[][] f = new int[m][n];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(i == 0 && j == 0) {
                    f[0][0] = 1; // 前面已经排除了起点是障碍的情况
                } else if(i == 0) {
                    if(obstacleGrid[i][j] == 1) {
                        f[i][j] = 0;
                    } else {
                        f[i][j] = f[i][j-1];
                    }
                } else if(j == 0) {
                    if(obstacleGrid[i][j] == 1) {
                        f[i][j] = 0;
                    } else {
                        f[i][j] = f[i-1][j];
                    }
                } else {
                    if(obstacleGrid[i][j] == 1) {
                        f[i][j] = 0;
                    } else {
                        f[i][j] = f[i-1][j] + f[i][j-1];
                    }
                }
            }
        }
        return f[m-1][n-1];
    }
}
