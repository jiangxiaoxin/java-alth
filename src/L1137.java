public class L1137 {

    public static void main(String[] args) {
//        System.out.println(tribonacci(4));
        System.out.println(tribonacci(25));
    }

//    T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
    public static int tribonacci(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 1;
        }
        int[] f = new int[n+1]; // 经常创建的数组长度是n+1
        f[0] = 0;
        f[1] = 1;
        f[2] = 1;
        int i=3;
        while(i <= n) {
            f[i] = f[i-1] + f[i-2] + f[i-3];
            i++;
        }
        return f[i-1];
    }
}
