package leetcode;


public class L746 {

    public static void main(String[] args) {
//        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        int[] cost = {10,15,20};
        System.out.println(minCostClimbingStairs(cost));
    }
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int fi_2 = 0; // f[0] ,初始时可以直接站上去，所以最低花费0
        int fi_1 = 0; // f[1]，与f[0]同理
        // f[i] = 到达 i 这个位置的最低花费
        // 要到达顶部，i应该是数组cost的length
        int i = 2;
        int fi = 0;
        while(i <= n) {
            // i <= n， 所以i-1和i-2一直是有效的
            fi = Math.min(fi_1 + cost[i-1], fi_2 + cost[i-2]);
            fi_2 = fi_1;
            fi_1 = fi;
            i++;
        }
        return fi;
    }
}
