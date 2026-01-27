

public class L198 {

    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};

//        int[] nums = {100};
//        int[] nums = {100, 200};

        System.out.println(rob(nums));
    }
//    1 <= nums.length <= 100
    public static int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return nums[0];
        }
        // 长度超过2
        int[] f = new int[n]; // f[i] 过了[i]这个房子后能拿到的最高金额
        f[0] = nums[0];
        f[1] = Math.max(nums[0], nums[1]);
        int i=2;
        while(i<n) {
            f[i] = Math.max(f[i-1], f[i-2]+nums[i]);
            i++;
        }
        return f[n-1];
    }
}
