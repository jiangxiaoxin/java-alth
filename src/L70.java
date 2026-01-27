

public class L70 {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(climbStairs(n));
    }

    /**
     * 1 <= n <= 45
     * @param n
     * @return
     */

    public static int climbStairs(int n) {
        if(n == 1) {
            return 1;
        }
        int fn_2 = 1; // 这是初始代表 f[0] = 1
        int fn_1 = 1;// 这初始代表 f[1] = 1
        int fi = 0;// 这个初始化是不准确的，纯粹为了不报错
        int i = 2;
        while(i<=n){
            fi = fn_1 + fn_2;
            fn_2 = fn_1;
            fn_1 = fi;
            i++;
        }
        return fi;
    }
}
