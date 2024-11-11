import java.util.*;
import java.io.*;

public class Main {
    public static int num;
    public static int[] note;

    public static int dp(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 3;
        if (note[n] == 0) note[n] = (dp(n-1) + dp(n-2)) % 10007;
        return note[n];
    }

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        num = Integer.parseInt(st.nextToken());
        note = new int[num + 1];

        System.out.print(dp(num));
    }
}