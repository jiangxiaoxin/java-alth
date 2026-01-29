package leetcode;
import java.util.Arrays;

public class 最大连续1的个数 {

	public 最大连续1的个数() {
		// TODO Auto-generated constructor stub
	}
	
	public static int findMaxConsecutiveOnes(int[] nums) {
		int count = 0;
		int left;
		int right;
		for(int i=0;i<nums.length;) {
			left = i;
			right = i;
			while(right < nums.length && nums[right] == 1) {
				right++;
			}
			//right 指向的肯定不是1，而是0
			count = Math.max(count, right-left);
			// 既然right 不是1，那再以right 为下一个巡查点也就没必要了，直接去下一个点
			i = right+1; 
		}
		return count;
    }

	public static void main(String[] args) {
//		int[] nums = {1,1,0,1,1,1};
		int[] nums = {0,1,1,1,1,1};
		int count = findMaxConsecutiveOnes(nums);
		System.out.println(count);

	}

}
