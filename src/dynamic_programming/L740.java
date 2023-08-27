package dynamic_programming;

public class L740 {

    public static void main(String[] args) {
//        int[] nums = {3,4,2};
        int[] nums = {2,2,3,3,3,4};
        System.out.println(deleteAndEarn(nums));
    }

//    1 <= nums.length <= 2 * 104
//    1 <= nums[i] <= 104
    public static int deleteAndEarn(int[] nums) {
    // 选中nums[i]之后，就不能选中nums[i]-1,和nums[i]+1,这很像不能选中连续相邻的两个房子
//        问题的关键是如何将这道题转换为抢劫的类型
        int maxVal = 0;
        int n = nums.length;
        for(int i=0;i<n;i++) {
            if(nums[i] > maxVal) {
                maxVal = nums[i];
            }
        }
        // 找出maxVal, 构建对应的数组
//        sum 数组里就是以 nums数组里对应的值为index了。这样就可以将nums[i],nums[i]-1,nums[i]+1转换成sum里的[x],[x-1], [x+1]
        int[] sum = new int[maxVal+1];
        for(int i=0;i<n;i++) {
            sum[nums[i]] += nums[i];
        }
        // sum 计算了从0到maxVal对应的和
//        因为 nums[i] >= 1, 所以maxVal >= 1, 所以sum.length >= 2,所以sum[0], sum[1]一定存在。所以可以直接到下面
        int[] f = new int[maxVal+1];
        f[0] = sum[0];
        f[1] = Math.max(sum[0], sum[1]);
        for(int i=2;i<f.length;i++) {
            f[i] = Math.max(f[i-1], f[i-2] + sum[i]);
        }
        return f[maxVal];
    }
}
