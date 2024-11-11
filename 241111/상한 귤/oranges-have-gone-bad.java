import java.util.*;
import java.io.*;

public class Main {
    public static int n, k;
    public static int[][] arr;
    public static Queue<int[]> q = new LinkedList<>();
    public static int[][] result;

    public static void bfs() {
        int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0], y = curr[1];
            for (int[] direction : directions) {
                int nx = x + direction[0];
                int ny = y + direction[1];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n && result[nx][ny] == 0 && arr[nx][ny] == 1) {
                    result[nx][ny] = result[x][y] + 1;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        result = new int[n][n];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) q.add(new int[]{i, j});
                else if (arr[i][j] == 0) result[i][j] = -1;
            }
        }

        bfs();

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) System.out.print(result[i][j] + " ");
            System.out.println();
        }
    }
}