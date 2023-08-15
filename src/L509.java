public class L509 {

    public static void main(String[] args) {
        System.out.println(fib(4));
    }

    // 0 <= n <= 30
    public static int fib(int n) {
        if(n==0) {
            return 0;
        }
        if(n==1) {
            return 1;
        }
        int[] fibs = new int[n+1];
        fibs[0] = 0;
        fibs[1] = 1;
        int i=2;
        while(i<=n){
            fibs[i] = fibs[i-1] + fibs[i-2];
            i++;
        }
        return fibs[n];
    }
}
