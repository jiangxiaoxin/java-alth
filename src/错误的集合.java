import java.util.Arrays;

public class 错误的集合 {

	public 错误的集合() {
		// TODO Auto-generated constructor stub
	}

//	[重复的数，丢失的整数]
	public static int[] findErrorNums(int[] nums) {
		int[] errorNums = new int[2];
		int n = nums.length;
		Arrays.sort(nums);
		int prev = 0;
		for (int i = 0; i < n; i++) {
			int curr = nums[i];
			if (curr == prev) {
				errorNums[0] = prev;
			} else if (curr - prev > 1) {
				errorNums[1] = prev + 1;
			}
			prev = curr;
		}
		if (nums[n - 1] != n) {
			errorNums[1] = n;
		}
		return errorNums;
	}

	public static void main(String[] args) {
//		int[] nums = { 1, 2, 4, 2 };
//		int[] nums = {2,2};
//		int[] nums = { 1, 1 };
//		int[] nums = { 3, 2, 3, 4, 6, 5 };
		int[] nums = {1,2,3,3,5};
		int[] result = findErrorNums(nums);
		System.out.println(Arrays.toString(result));
	}

}
