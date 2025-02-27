import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] note = new int[N];        // LIS
        int[] inverseNote = new int[N]; // LDS

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(note, 1);
        Arrays.fill(inverseNote, 1);

        // LIS 계산
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    note[i] = Math.max(note[i], note[j] + 1);
                }
            }
        }

        // LDS 계산 (기존 arr을 뒤에서 탐색)
        for (int i = N - 2; i >= 0; i--) {
            for (int j = N - 1; j > i; j--) {
                if (arr[i] > arr[j]) {
                    inverseNote[i] = Math.max(inverseNote[i], inverseNote[j] + 1);
                }
            }
        }

        // 최장 증가-감소 부분 수열 찾기
        int maxLength = 0;
        for (int i = 0; i < N; i++) {
            maxLength = Math.max(maxLength, note[i] + inverseNote[i] - 1);
        }

        System.out.println(maxLength);
    }
}