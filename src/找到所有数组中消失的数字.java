import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 找到所有数组中消失的数字 {

	public 找到所有数组中消失的数字() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums
	 * 中的数字，并以数组的形式返回结果
	 */

//	public static List<Integer> findDisappearedNumbers(int[] nums) {
//		// 先去重 再查找
//		Set<Integer> set = new HashSet<Integer>();
//		for(int i=0;i<nums.length;i++) {
//			set.add(nums[i]);
//		}
//		List<Integer> result = new ArrayList<Integer>();
//		for(int i=1;i<=nums.length;i++) {
//			if(set.contains(i) == false) {
//				result.add(i);
//			}
//		}
//		return result;
//	}
	
	public static List<Integer> findDisappearedNumbers(int[] nums) {
		int n = nums.length;
		int[] f = new int[n+1];
		List<Integer> result = new ArrayList<Integer>();
		for(int i=0;i<n;i++) {
			f[nums[i]] = 1;
		}
		for(int i=1;i<n+1;i++) {
			if(f[i] == 0) {
				result.add(i);
			}
		}
		return result;
	}

	public static void main(String[] args) {
//		int[] nums = {4,3,2,7,8,2,3,1};
		int[] nums = {1,1};
		List<Integer> result = findDisappearedNumbers(nums);
		System.out.println(result);

	}

}
