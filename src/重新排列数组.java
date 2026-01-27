import java.util.Arrays;

public class 重新排列数组 {

	public 重新排列数组() {
		// TODO Auto-generated constructor stub
	}

	public static int[] shuffle(int[] nums, int n) {
		int newArr[] = new int[n*2];
		for(int i=0;i<n;i++) {
			newArr[i*2] = nums[i];
			newArr[i*2+1] = nums[i+n];
		}
		return newArr;
	}

	public static void main(String[] args) {
		int arr[] = {2,5,1,3,4,7};
		int newArr[] = shuffle(arr, arr.length>>1);
		System.out.println(Arrays.toString(newArr));
	}

}
