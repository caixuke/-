import java.util.*;

/**
 * Created by Rexxar on 2017/3/5.
 */

public class Main {
    static int maxn = -1;
    static Queue<Integer> q = new LinkedList<>();

    static int bfs(int a, int b, int k) {
        int t = a + b;
        int x;
        boolean[] visited = new boolean[a + b + 1];
        int[] dist = new int[a + b + 1];
        int[] offset = new int[a + b + 1];
        for (int i = 0; i <= t; i++) {

        }
        q.offer(a);
        visited[a] = true;
        dist[a] = 0;
        while (!q.isEmpty()) {
            x = q.poll();
            if (x == 0) {
//                for (int i = 0; i <= t; i++) {
//                    System.out.print(dist[i] + " ");
//                }
//                System.out.println();
                return dist[0];
            }
            for (int i = 0; i <= k; i++) {
                if (i <= x && k - i <= (t - x) &&
                        x - i + k - i >= 0 && (t - x) + i - (k + i) <= t && !visited[x - i + k - i]) {
                    q.offer(x - i + k - i);
                    visited[x - i + k - i] = true;
                    dist[x - i + k - i] = dist[x] + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a, b, k;
        a = scanner.nextInt();
        b = scanner.nextInt();
        k = scanner.nextInt();

        System.out.println(bfs(a, b, k));

    }
}