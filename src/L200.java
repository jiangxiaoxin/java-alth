

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class L200 {
	/**
	 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。

岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。

此外，你可以假设该网格的四条边均被水包围。
	 * @param args
	 */

	public static void main(String[] args) {
//		String s = "[[\"1\",\"1\",\"1\",\"1\",\"0\"],[\"1\",\"1\",\"0\",\"1\",\"0\"],[\"1\",\"1\",\"0\",\"0\",\"0\"],[\"0\",\"0\",\"0\",\"0\",\"0\"]]";
		String s = "[\n" +
				"  [\"1\",\"1\",\"0\",\"0\",\"0\"],\n" +
				"  [\"1\",\"1\",\"0\",\"0\",\"0\"],\n" +
				"  [\"0\",\"0\",\"1\",\"0\",\"0\"],\n" +
				"  [\"0\",\"0\",\"0\",\"1\",\"1\"]\n" +
				"]";
		char[][] grid = Utils.stringToChar2dArray(s);
		System.out.println(numIslands(grid));
	}

	/**
	 * 这个实现性能比较慢
	 * bfs，广度优先搜索，找到一个合适的点后，就往外一层层扩展，标记矩阵
	 * 1. 建立新的visited矩阵，要不断地访问和修改
	 * 2. 矩阵中的点会被重复遍历
	 * @param grid
	 * @return
	 */
	public static int numIslands(char[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		// 上，右，下，左
		int[][] dirs = {{-1,0},{0,1},{1, 0},{0, -1}};
		int count = 0;
		// 0-未访问 1-已经算过了
		int[][] visited = new int[m][n];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(grid[i][j] == '1' && visited[i][j] == 0) {
					// 找到一块从来没标记过的陆地
					count++;
					/**
					 * 找出与他相邻却没访问过的1-陆地
					 * 需要往左和往上找吗？不需要。因为往左和往上肯定找不到没有访问过的陆地。
					 * 假设之前的格子里有相邻的是陆地，那当前这块又是陆地，那按照规则是会标记当前格子为已访问的。
					 * 现在到达当前节点时发现是新鲜的陆地，那一定是之前的陆地跟当前的陆地不相连的。
					 * 但此时左下方的格子是有可能存在未访问过的陆地的，甚至是跟当前陆地通过周围的格子连接起来。
					 */
					Deque<Integer> queue = new ArrayDeque<Integer>();
					queue.offer(i);
					queue.offer(j);
					while(queue.isEmpty() == false)
					{
						int x = queue.poll();
						int y = queue.poll();
						if(grid[x][y] == '1' && visited[x][y] == 0) {
							visited[x][y] = 1;
							for(int z=0;z<dirs.length;z++) 
							{
								int nx = x + dirs[z][0];
								int ny = y + dirs[z][1];
								if(nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == '1' && visited[nx][ny] == 0)
								{
									queue.offer(nx);
									queue.offer(ny);
								}
							}
						}
					}
				}
			}
		}
		return count;
	}

}
