import java.util.*;
import java.io.*;

public class Main {
    public static int[] note;
    public static int N;

    public static void fibo(int n) {
        if (n-1 >= N) {
            System.out.println(note[N]);
            return;
        } else {
            note[n] = note[n-1] + note[n-2];
            fibo(n+1);
        }
        return;
    }

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        note = new int[N*N];
        note[1] = 1;
        note[2] = 1;
        fibo(3);
    }
}