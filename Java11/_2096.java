import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _2096 {
    public static int max(int a, int b) {
        return a > b ? a : b;
    }

    public static int max3(int a, int b, int c) {
        return max(max(a, b), c);
    }

    public static int min(int a, int b) {
        return a < b ? a : b;
    }

    public static int min3(int a, int b, int c) {
        return min(min(a, b), c);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] dpMax = new int[3];
        int[] dpMin = new int[3];
        int[] curMax = new int[3]; // 현재 step에서 (0,1)의 최솟값, (0,1,2)의 최솟값, (1,2)의 최솟값
        int[] curMin = new int[3]; // 현재 step에서 (0,1)의 최댓값, (0,1,2)의 최댓값, (1,2)의 최댓값
        int A, B, C;

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            dpMax[0] = A + curMax[0];
            dpMax[1] = B + curMax[1];
            dpMax[2] = C + curMax[2];

            curMax[0] = max(dpMax[0], dpMax[1]);
            curMax[1] = max3(dpMax[0], dpMax[1], dpMax[2]);
            curMax[2] = max(dpMax[1], dpMax[2]);

            dpMin[0] = A + curMin[0];
            dpMin[1] = B + curMin[1];
            dpMin[2] = C + curMin[2];

            curMin[0] = min(dpMin[0], dpMin[1]);
            curMin[1] = min3(dpMin[0], dpMin[1], dpMin[2]);
            curMin[2] = min(dpMin[1], dpMin[2]);

        }

        bw.write(curMax[1] + " " + curMin[1]);

        br.close();
        bw.flush();
        bw.close();
    }

}
