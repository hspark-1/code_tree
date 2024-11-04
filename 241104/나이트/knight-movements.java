import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[] start = new int[2], end = new int[2];
    public static int[][] isVisited;
    public static Queue<int[]> q = new LinkedList<>();

    public static void bfs() {
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0], y = curr[1];
            int[][] directions = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}};

            for (int[] direction : directions) {
                int nx = x+direction[0], ny = y+direction[1];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && isVisited[nx][ny]==0) {
                    isVisited[nx][ny] = isVisited[x][y] + 1;
                    if (nx == end[0]-1 && ny == end[1]-1) return;
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
        isVisited = new int[n][n];
        
        st = new StringTokenizer(br.readLine());
        start[0] = Integer.parseInt(st.nextToken());
        start[1] = Integer.parseInt(st.nextToken());
        end[0] = Integer.parseInt(st.nextToken());
        end[1] = Integer.parseInt(st.nextToken());

        q.add(new int[]{start[0]-1, start[1]-1});
        bfs();

        System.out.println((isVisited[end[0]-1][end[1]-1] == 0) ? -1 : isVisited[end[0]-1][end[1]-1]);
    }
}