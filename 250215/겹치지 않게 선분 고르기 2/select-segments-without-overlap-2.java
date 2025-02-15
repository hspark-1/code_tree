import java.util.*;
import java.io.*;

public class Main {
    public static int N;
    public static int[][] arr;
    public static int[] note;

    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        note = new int[N];

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<2; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o2[0] - o1[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });

        note[0] = 1;
        int prev = arr[0][1];
        for (int i=1; i<N; i++) {
            if (arr[i][0] > prev) {
                note[i] = 1;
                prev = arr[i][1];
            }
        }

        int ans = 0;
        for (int i=0; i<N; i++) {
            if (note[i] == 1) ans++;
        }
        System.out.print(ans);
    }
}