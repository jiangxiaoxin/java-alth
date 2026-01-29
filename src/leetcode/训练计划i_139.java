package leetcode;

import java.util.Arrays;

public class 训练计划i_139 {

    /**
     * 教练使用整数数组 actions 记录一系列核心肌群训练项目编号。
     * 为增强训练趣味性，需要将所有奇数编号训练项目调整至偶数编号训练项目之前。
     * 请将调整后的训练项目编号以 数组 形式返回
     */

    public static int[] trainingPlan(int[] actions) {
        /**
         * 先找一个偶数的编号
         * 再从后面找一个奇数的编号
         * 这两个位置互换
         * 更新下一个指针
         *【这个方法没超标，但时间很慢】
         */
        int n = actions.length;
        int index = 0;
        while(index < n) {
            int even = -1;// index
            for(int i=index;i<n;i++) {
                if(actions[i] % 2 == 0) {
                    even = i;
                    break;
                }
            }
            if(even == -1) {
             // 找不到偶数
             return actions;
            }
            int odd = -1;
            for(int i=even+1;i < n;i++) {
                if(actions[i] % 2 == 1) {
                    odd = i;
                    break;
                }
            }
            if(odd == -1) {
                // 找不到奇数
                return actions;
            }
            int temp = actions[even];
            actions[even] = actions[odd];
            actions[odd] = temp;
            index = even + 1;
        }

        return actions;
    }

    public static int[] trainingPlan2(int[] actions) {
        /**
         * 目的是找一个偶数和一个奇数编号，然后互换。
         * 那从两头开始找，既能找偶数和奇数，也能在index碰上的时候直接跳出循环，减少计算量
         * 妙啊
         * 上面那个是n*n，这个是n就够了
         */
        int n = actions.length;
        int left = 0;
        int right = n-1;
        while(left < right) {
            if(actions[left] % 2 == 1) {
                left++;
            } else if(actions[right] % 2 == 0) {
                right--;
            } else {
                int temp = actions[left];
                actions[left] = actions[right];
                actions[right] = temp;
                left++;
                right--;
            }
        }
        return actions;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,5,6,7,8};
        int[] nums2 = {1,2,3,4,5,6,7,8, 9};
        int[] nums3 = {1};
        int[] nums4 = {1,2};
        int[] nums5 = {1,2,3};
        int[] nums6 = {2,1,2,2,4,6};
//        System.out.println(Arrays.toString(trainingPlan(nums1)));
//        System.out.println(Arrays.toString(trainingPlan(nums2)));
//        System.out.println(Arrays.toString(trainingPlan(nums3)));
//        System.out.println(Arrays.toString(trainingPlan(nums4)));
//        System.out.println(Arrays.toString(trainingPlan(nums5)));
//        System.out.println(Arrays.toString(trainingPlan(nums6)));
//        System.out.println(Arrays.toString(trainingPlan2(nums6)));

    }
}
