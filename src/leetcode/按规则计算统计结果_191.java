package leetcode;

import java.util.Arrays;

public class 按规则计算统计结果_191 {

    /**
     * 为了深入了解这些生物群体的生态特征，你们进行了大量的实地观察和数据采集。数组 arrayA 记录了各个生物群体数量数据，其中 arrayA[i] 表示第 i 个生物群体的数量。请返回一个数组 arrayB，该数组为基于数组 arrayA 中的数据计算得出的结果，其中 arrayB[i] 表示将第 i 个生物群体的数量从总体中排除后的其他数量的乘积
     *
     * 有可能存在0！！！
     */


    public static int[] statisticalResult(int[] arrayA) {
        /**
         * 这个方法是分析了乘积的各种情况后，利用乘积的特性实现的
         * 因为已经考虑了0的存在，所以可以安全的使用除法
         */
        int n = arrayA.length;
        int[] b = new int[n];
        int res = 1; // 非零的乘积
        int zero = 0;
        for (int i = 0; i < n; i++) {
            if (arrayA[i] == 0) {
                zero++;
            } else {
                res *= arrayA[i];
            }
        }
        if (zero == n) {
            // 都是0
            // b默认就已经都是0了
        } else {
            // 不都是0，那res 就是有效的
            for (int i = 0; i < n; i++) {
                if (arrayA[i] == 0) {
                    if (zero == 1) {
                        b[i] = res;
                    } else if (zero >= 2) {
                        // 去掉自己后，还有起码1个0
                        b[i] = 0;
                    }
                    // 不用再else了，因为都已经arrayA[i] == 0了, 那就zero肯定 >=1
                } else {
                    // 当前这个数不是0，那非零乘积res 肯定有值
                    if (zero >= 1) {
                        b[i] = 0;
                    } else {
                        b[i] = res / arrayA[i];
                    }
                }
            }
        }
        return b;
    }

    public static int[] statisticalResult2(int[] arrayA) {
        /**
         * b[i] = a0 * a1 * a(i-1)    *     a(i+1) * ... * a(n-1)
         * 简化就是 b[i] = left[i] * right[i]
         * left[i] = left[i-1] * a(i-1)
         * right[i] = right[i+1] * a(i+1)
         * i从0开始往后走，计算好left，然后再往回走，计算好right[i].
         * 计算好right[i]时，就可以计算出b[i]了
         */
        int n = arrayA.length;
        if(n == 0) {
            return new int[0];
        }
        int[] b = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 1;
        for (int i=1; i < n; i++) {
            left[i] = left[i-1] * arrayA[i-1]; // 最小从[0]开始，不会报错
        }
        // 一直算到left[n-1], 然后开始算right
        right[n-1] = 1;
        b[n-1] = left[n-1] * right[n-1];
        for (int i=n-2; i >= 0; i--) {
            right[i] = right[i+1] * arrayA[i+1];
            b[i] = left[i] * right[i];
        }
        return b;
    }

    public static void main(String[] args) {
        int[] num1 =    {1,2,0,4,5};
        int[] num2 = {1,2,0,4,0,5};
        System.out.println(Arrays.toString(statisticalResult2(num1)));
        System.out.println(Arrays.toString(statisticalResult2(num2)));
    }
}
