import java.util.*;
import java.io.*;

public class Main {
    public static int n, k;
    public static int[][] arr;
    public static int r1, c1, r2, c2;
    public static int[] deletePosition;
    public static int[][] isVisited;
    public static Queue<int[]> q = new LinkedList<>();
    public static int min_result;

    public static void deleteWalls() {
        int a = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (deletePosition.length < a) break;
                if (arr[i][j] == 1) {
                    if (deletePosition[a] == 0) arr[i][j] = 0;
                    a++;
                }
            }
        }
    }

    public static void bfs() {
        int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0], y = curr[1];
            
            for (int[] direction : directions) {
                int nx = x + direction[0], ny = y + direction[1];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && isVisited[nx][ny] == 0 && arr[nx][ny] == 0) {
                    q.add(new int[]{nx, ny});
                    isVisited[nx][ny] = isVisited[x][y] + 1;
                }
            }
        }
    }

    public static int permutation() {
        int changeIdx = -1;
        for (int i=deletePosition.length-2; i>=0; i--) {
            if (deletePosition[i] < deletePosition[i+1]) {
                changeIdx = i;
                break;
            }
        }
        if (changeIdx == -1) return -1;

        int idx=changeIdx+1;
        int tmp = deletePosition[idx];
        deletePosition[idx] = deletePosition[changeIdx];
        deletePosition[changeIdx] = tmp;

        Arrays.sort(deletePosition, changeIdx+1, deletePosition.length);

        return 1;
    }

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int cntWalls = 0;
        min_result = n * n;

        arr = new int[n][n];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) cntWalls++;
            }
        }

        st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken()) - 1;
        c1 = Integer.parseInt(st.nextToken()) - 1;
        st = new StringTokenizer(br.readLine());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        int[][] cpArr = new int[n][n];
        for (int i=0; i<n; i++) cpArr[i] = arr[i].clone();
        deletePosition = new int[cntWalls];
        for (int i=k; i<cntWalls; i++) deletePosition[i] = 1;

        while(true) {
            deleteWalls();
            isVisited = new int[n][n];
            q.add(new int[]{r1, c1});
            bfs();
            if (isVisited[r2-1][c2-1] > 0 && min_result > isVisited[r2-1][c2-1]) min_result = isVisited[r2-1][c2-1];
            if(permutation() == -1) break;
            for (int i=0; i<n; i++) arr[i] = cpArr[i].clone();
        }

        System.out.println((min_result == n*n) ? -1 : min_result);
    }
}