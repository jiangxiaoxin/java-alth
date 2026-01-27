

public class L64 {

//    给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小
//    每次只能向下或者向右移动一步
    public static void main(String[] args) {
//        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};

        int[][] grid = {{1,2,3},{4,5,6}};
        System.out.println(minPathSum(grid));
    }

//    1 <= m, n <= 200
//    0 <= grid[i][j] <= 200
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] f = new int[m][n];

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(i == 0 && j == 0) {
                    // 左上角
                    f[i][j] = grid[0][0];
                } else if(i == 0) {
                    // 第0行
                    f[i][j] = f[i][j-1] + grid[i][j];
                } else if(j == 0) {
                    // 第0列
                    f[i][j] = f[i-1][j] + grid[i][j];
                } else {
                    f[i][j] = Math.min(f[i-1][j] + grid[i][j], f[i][j-1] + grid[i][j]);
                }
            }
        }
        return f[m-1][n-1];
    }
}
