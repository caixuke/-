import java.util.*;

/**
 * Created by Rexxar on 2017/3/5.
 */

public class Main {
    static Queue<Integer> q = new LinkedList<>();
    static int bfs(int a, int b, int k) {
        int t = a + b;
        int x;
        boolean[] visited = new boolean[a + b + 1];
        int[] dist = new int[a + b + 1];
        int[] offset = new int[a + b + 1];
        q.offer(a);
        visited[a] = true;
        dist[a] = 0;
        while (!q.isEmpty()) {
            x = q.poll();
            if (x == 0) {
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

import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int K = sc.nextInt();
        sc.close();
        int g = A % K;
        if (g == 0) {//能直接整除
            System.out.println(A / K);
            return;
        }
        if (A + B <= K) {//缺少交换空间
            System.out.println("-1");
            return;
        }
        if ((K % 2 == 0) && (g % 2 == 1)) {//剩余0的个数总为奇数，不可能有结果
            System.out.println("-1");
            return;
        }
        //下面分支对交换空间是否充足进行分析
        //交换空间成立条件A + B - g >= K - g / 2（其中最差的情况就是g=2时）
        //说明只要在一次交换中尽可能减小g的值，就能最快的完成全部交换
        if (g == A) {
            int count = 0;
            if (K % 2 == 0) {//如果K为偶数，则当前剩余0的个数一定是偶数
                while (true) {
                    if ((g % 2 == 0) && (A + B - g >= K - g / 2)) {
                        count = count + 2;
                        break;
                    }
                    if (count % 2 == 0) {
                        count++;
                        g = A + B - (K - (A + B - g));
                    }
                    if (count % 2 == 1) {
                        count++;
                        g = K - g;
                    }
                }
            } else {
                while (true) {//如果K为偶数，则当前剩余0的个数是一次奇数一次偶数的交替
                    if ((g % 2 == 0) && (A + B - g >= K - g / 2)) {
                        count = count + 2;
                        break;
                    }
                    if (g % 2 == 0) {
                        count++;
                        g = A + B - (K - (A + B - g));
                    }
                    if (g % 2 == 1) {
                        count++;
                        g = K - g;
                    }
                }
            }
            System.out.println(A / K + count);
            return;
        }
        if (A > 2 * K||B >(K+(g-A)/2)) {
            //举例A=10000 B=10000 K=548时，不需要贪心的交换到A剩余136的时候
            //只需要交换到684的时候，进行两次交换即可全1，而不是贪心到底要多一次
            System.out.println(A / K + 1);
            return;
        }
        if (g < A)
            if (g % 2 == 0) {
                System.out.println(A / K + 2);
                return;
            } else {
                System.out.println(A / K + 3);
                return;
            }
    }
}
