import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int[] arr, inverseArr;
    public static int[] note, inverseNote;

    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        note = new int[N];
        inverseArr = new int[N];
        inverseNote = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            inverseArr[N - 1 - i] = arr[i];
        }

        for (int i=1; i<N; i++) {
            for (int j=0; j<i; j++) {
                if (note[j] == Integer.MIN_VALUE)
                    continue;
                if (arr[j] < arr[i])
                    note[i] = Math.max(note[i], note[j] + 1);
            }
        }

        for (int i=1; i<N; i++) {
            for (int j=0; j<i; j++) {
                if (inverseNote[j] == Integer.MIN_VALUE)
                    continue;
                if (inverseArr[j] < inverseArr[i])
                    inverseNote[i] = Math.max(inverseNote[i], inverseNote[j] + 1);
            }
        }

        int ans = 0, idx = 0;
        for (int i=0; i<N; i++) {
            if (ans == note[i]) continue;
            ans = Math.max(ans, note[i]);
            if (ans == note[i]) idx = i;
        }
        
        int inverseAns = 0, inverseIdx = 0;
        for (int i=0; i<N; i++) {
            if (inverseAns == inverseNote[i]) continue;
            inverseAns = Math.max(inverseAns, inverseNote[i]);
            if (inverseAns == inverseNote[i]) inverseIdx = i;
        }

        if (!(idx > (N - 1 - inverseIdx))) {
            if (arr[idx] == inverseArr[inverseIdx]) System.out.print(ans + inverseAns + 1);
            else System.out.print("Test Case");
        } else {
            // System.out.println(inverseNote[N - 1 - idx]);
            // System.out.println("ans : " + ans + ", inverse ans : " + inverseAns);
            System.out.print(Math.max((Math.max(ans, inverseAns) + 1), (inverseNote[N - 1 - idx] + ans + 1)));
        }
    }
}