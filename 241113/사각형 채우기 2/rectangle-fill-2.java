import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[] note;

    public static int solution(int num) {
        if (num == 0) return 0;
        if (num == 1) return 1;
        if (num == 2) return 3;

        if (note[num] == 0) note[num] = solution(num-1) + solution(num-2) * 2;
        return note[num];
    }

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        note = new int[n+1];
        System.out.print(solution(n));
    }
}