package leetcode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 有多少小于当前数字的数字 {

	public 有多少小于当前数字的数字() {
	}
//	给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目. 要按原顺序返回
	public static int[] smallerNumbersThanCurrent(int[] nums) {
		int n = nums.length;

		int newNums[] = Arrays.copyOf(nums, n);
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Arrays.sort(newNums);

		map.put(newNums[0], 0);
		for (int i = 1; i < n; i++) {
			if (newNums[i] > newNums[i - 1]) {
				map.put(newNums[i], i);
			}
		}
		int[] result = new int[n];
		for (int i = 0; i < n; i++) {
			result[i] = map.get(nums[i]);
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 8, 1, 2, 2, 3 };
		int[] result = smallerNumbersThanCurrent(nums);
		System.out.println(Arrays.toString(result));
	}

}
