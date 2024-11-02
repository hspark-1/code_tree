import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] arr;
    static boolean[][] isVisited;
    static int min;

    public static int solution(int x, int y, int depth) {
        isVisited[x][y] = true;
        int nDepth = depth++;
        if (x+1 == n && y+1 == m) return nDepth;
        int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};

        for (int[] direction:directions) {
            int nx = x + direction[0];
            int ny = y + direction[1];

            if (nx >= 0 && ny >= 0 && nx < n && ny < m && !isVisited[nx][ny] && arr[nx][ny] == 1) {
                int a = solution(nx, ny, depth);
                if (a > nDepth) {
                    nDepth = a;
                    if (min > nDepth && isVisited[n-1][m-1]) min = nDepth;
                }
            }
        }

        return min;
    }

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        min = n*m;

        arr = new int[n][m];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        isVisited = new boolean[n][m];
        System.out.print(solution(0, 0, 0));
    }
}