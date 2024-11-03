import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static int[][] arr;
    public static int[][] isVisited;
    public static Queue<int[]> queue = new LinkedList<>();

    public static void bfs() {
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1];
            int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};

            for (int[] direction : directions) {
                int nx = x+direction[0], ny = y+direction[1];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && isVisited[nx][ny] == 0 && arr[nx][ny] == 1) {
                    isVisited[nx][ny] = isVisited[x][y] + 1;
                    if (nx+1 == n && ny+1 == m) return;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        isVisited = new int[n][m];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        queue.add(new int[]{0, 0});
        bfs();
        System.out.println((isVisited[n-1][m-1] != 0) ? isVisited[n-1][m-1] : -1);
    }
}