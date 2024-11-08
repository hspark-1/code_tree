import java.util.*;
import java.io.*;

public class Main {
    public static Queue<int[]> q = new LinkedList<>();

    public static int bfs() {
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            if (curr[0] == 1) return curr[1];

            int n, depth;
            depth = curr[1] + 1;

            if (curr[0] % 3 == 0) {
                n = curr[0] / 3;
                q.add(new int[]{n, depth});
            }

            if (curr[0] % 2 == 0) {
                n = curr[0] / 2;
                q.add(new int[]{n, depth});
            }

            if (curr[0] + 1 % 2 == 0 || curr[0] + 1 % 3 == 0) {
                n = curr[0] + 1;
                q.add(new int[]{n, depth});
            }

            if (curr[0] - 1 % 2 == 0 || curr[0] - 1 % 3 == 0) {
                n = curr[0] - 1;
                q.add(new int[]{n, depth});
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        q.add(new int[]{N, 0});
        System.out.println(bfs());
    }
}