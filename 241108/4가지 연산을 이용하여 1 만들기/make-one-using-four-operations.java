import java.util.*;
import java.io.*;

public class Main {
    public static Queue<int[]> q = new LinkedList<>();
    public static int[] dp;
    public static int N;

    public static int bfs() {
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            if (N < curr[0]) continue;
            if (curr[0] == 1) return curr[1];

            int n, depth;
            depth = curr[1] + 1;

            if (curr[0] % 3 == 0) {
                n = curr[0] / 3;
                if (dp[n] == 0) {
                    q.add(new int[]{n, depth});
                    dp[n] = depth;
                }
            }

            if (curr[0] % 2 == 0) {
                n = curr[0] / 2;
                if (dp[n] == 0) {
                    q.add(new int[]{n, depth});
                    dp[n] = depth;
                }
            }
            
            n = curr[0] + 1;
            if (!(n > N)) {
                if (dp[n] == 0) {
                    q.add(new int[]{n, depth});
                    dp[n] = depth;
                }
            }

            n = curr[0] - 1;
            if (dp[n] == 0) {
                q.add(new int[]{n, depth});
                dp[n] = depth;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        dp = new int[N+1];

        q.add(new int[]{N, 0});
        dp[N] = 0;
        System.out.println(bfs());
    }
}