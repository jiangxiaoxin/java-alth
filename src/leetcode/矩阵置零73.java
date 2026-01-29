package leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 矩阵置零73 {
	
	/**
	 * NO.73
	 * 这个方法并没有超时，可以用，占用O（m+n）内存和O(mn)的时间。其实时间不止一个mn，是3个
	 * 可以简化点：找出rows和cols以后，对matrix 从头遍历，对每一个判断对应的行和列是不是要置0。这样一次再加一次mn就可以了
	 * 
	 *关键是找出哪些行和哪些列要变成0，然后再挨个修改。
	 *而记录这些行和列，就可以用第0行和第0列来记录，而第0行和第0列原本要不要变，可以用两个单独的变量记录。
	 *这样整体使用的空间就可以认为是O（1）【不是说就1个单位或者字节什么的，而是说额外使用的空间跟m和n没关系，是常量】
	 */

	public static void main(String[] args) {
		int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
		setZeroes(matrix);
		System.out.println(matrix);
		System.out.println(Arrays.deepToString(matrix));;
	}
	
	public static void setZeroes(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		boolean[] rows = new boolean[m];
		boolean[] cols = new boolean[n];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(matrix[i][j] == 0) {
					rows[i] = true;
					cols[j] = true;
				}
			}
		}
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(rows[i] == true || cols[j] == true) {
					matrix[i][j] = 0;
				}
			}
		}
	}
	
//	public static void setZeroes(int[][] matrix) {
//		Set<Integer> rows = new HashSet<Integer>();
//		Set<Integer> cols = new HashSet<Integer>();
//		int m = matrix.length; // 题目中说了肯定不为0
//		int n = matrix[0].length;
//		for(int i=0;i<m;i++) {
//			for(int j=0;j<n;j++) {
//				if(matrix[i][j] == 0) {
//					rows.add(i);
//					cols.add(j);
//				}
//			}
//		}
////		for(Integer row : rows) {
////			for(int i=0;i<n;i++) {
////				matrix[row][i] = 0;
////			}
////		}
////		for(Integer col : cols) {
////			for(int i=0;i<m;i++) {
////				matrix[i][col] = 0;
////			}
////		}
//		for(int i=0;i<m;i++) {
//			for(int j=0;j<n;j++) {
//				if(rows.contains(i) || cols.contains(j)) {
//					matrix[i][j] = 0;
//				}
//			}
//		}
//		
//	}

}
