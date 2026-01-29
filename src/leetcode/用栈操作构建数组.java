package leetcode;
import java.util.ArrayList;
import java.util.List;

public class 用栈操作构建数组 {

	public static List<String> buildArray(int[] target, int n) {
		String Push = "Push";
		String Pop = "Pop";
		List<String> result = new ArrayList<String>();
		int index = 0;
		int current;
		int num = 1;
		int size = target.length;
		while (index < size) {
			current = target[index];
			for (int j = num; j <= n; j++) {
				result.add(Push);
				if (current == j) {
					index++;
					num++;
					break;
				} else {
					result.add(Pop);
					num++;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] target = { 1, 2 };
		int n = 4;
		List<String> result = buildArray(target, n);
		System.out.println(result);
	}

}
