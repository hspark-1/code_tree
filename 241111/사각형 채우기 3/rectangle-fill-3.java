import java.util.*;
import java.io.*;

public class Main {
    public static int num;
    public static long[] note;

    public static long dp(int n) {
        if (n == 1) return 2;
        if (n == 2) return 7;
        if (n == 3) return 22;
        if (n == 0) return 0;
        if (note[n] == 0) note[n] = (dp(n-1) * 2 + dp(n-2) * 3 + dp(n-3) * 2 + 2) % 1000000007;
        return note[n];
    }

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        num = Integer.parseInt(st.nextToken());
        note = new long[Math.max(num + 1, 4)];

        System.out.print(dp(num));
    }
}