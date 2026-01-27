



public class L931 {

    public static void main(String[] args) {
//        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
        int[][] matrix = Utils.stringToInt2dArray("[[100,-42,-46,-41],[31,97,10,-10],[-58,-51,82,89],[51,81,69,-51]]");

        System.out.println(minFallingPathSum(matrix));
    }

//    1 <= n <= 100
//    -100 <= matrix[i][j] <= 100
    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        // 第【0】行的不用处理
        int temp = Integer.MAX_VALUE;
        for(int i=1;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(j-1 < 0) {
                    temp = Integer.MAX_VALUE;
                } else {
                    temp = matrix[i-1][j-1];
                }
                temp = Math.min(temp, matrix[i-1][j]);
                if(j+1 < n) {
                    temp = Math.min(temp, matrix[i-1][j+1]);
                }
                matrix[i][j] = temp + matrix[i][j];
            }
        }
        int minVal = Integer.MAX_VALUE;
        for(int i=0;i<n;i++) {
            minVal = Math.min(minVal, matrix[n-1][i]);
        }
        return minVal;
    }
}
