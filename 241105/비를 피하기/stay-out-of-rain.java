import java.util.*;
import java.io.*;

public class Main {
    public static int n, h, m;
    public static int[][] arr;
    public static int[][] result;
    public static boolean[][] isVisited;
    public static Queue<int[]> q = new LinkedList<>();

    public static int bfs() {
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0], y = curr[1];
            isVisited[x][y] = true;
            int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};

            for (int[] direction : directions) {
                int nx = x + direction[0];
                int ny = y + direction[1];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n && !isVisited[nx][ny]) {
                    if (arr[nx][ny] == 3) return arr[x][y] - 1;
                    else if (arr[nx][ny] != 1) {
                        q.add(new int[]{nx, ny});
                        arr[nx][ny] = arr[x][y] + 1;
                    }
                }
            }
        }

        return -1;
    }

    public static void solution() {
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (arr[i][j] == 2) {
                    int[][] cpArr = new int[n][n];
                    for (int k=0; k<n; k++) cpArr[k] = arr[k].clone();
                    isVisited = new boolean[n][n];
                    q.add(new int[]{i, j});
                    result[i][j] = bfs();
                    for (int k=0; k<n; k++) {
                        for (int l=0; l<n; l++) System.out.print(arr[k][l] + " ");
                        System.out.println();
                    }
                    arr = cpArr;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        result = new int[n][n];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        solution();
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) System.out.print(result[i][j] + " ");
            System.out.println();
        }
    }
}