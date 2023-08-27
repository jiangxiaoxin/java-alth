package array;

import java.util.ArrayList;

public class L2682 {

    public static void main(String[] args) {
        int[] res = circularGameLosers(4, 4);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
    public static int[] circularGameLosers(int n, int k) {
        int[] visited = new int[n+1];
        int cnt = 1;
        int next;
        int cur = 1;
        visited[1] = 1;
        while (true) {
            next = (cur-1 + cnt * k) % n + 1;
            if(visited[next] == 1) {
                break;
            }
            visited[next] = 1;
            cur = next;
            cnt++;
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1;i<=n;i++) {
            if(visited[i] == 0) {
                list.add(i);
            }
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}
