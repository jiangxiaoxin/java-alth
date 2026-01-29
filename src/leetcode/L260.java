package leetcode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class L260 {
    /**
     * 给你一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
     *
     * 你必须设计并实现线性时间复杂度的算法且仅使用常量额外空间来解决此问题。
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {1,2,1,3,2,5};
        int[] res = singleNumber(nums);
        System.out.println(Arrays.toString(res));
    }

    public static int[] singleNumber(int[] nums) {
        // num - count of num
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] res = new int[2];
        int i=0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            if(entry.getValue() == 1) {
                res[i++] = entry.getKey();
            }
        }
        return res;
    }
}
