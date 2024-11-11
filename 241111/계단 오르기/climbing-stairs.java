import java.util.*;
import java.io.*;

public class Main {
    public static int num;
    public static long[] note;

    public static long dp(int n) {
        if (n == 2) return 1;
        if (n == 3) return 1;
        if (n == 1) return 0;
        if (note[n] == 0) {
            note[n] = (dp(n-2) + dp(n-3)) % 10007;
            return note[n];
        } else return note[n];
    }

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        num = Integer.parseInt(st.nextToken());
        note = new long[num+1];

        System.out.print(dp(num));
    }
}