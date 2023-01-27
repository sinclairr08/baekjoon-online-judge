import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _2579 {
    public static int max(int a, int b) {
        return a > b ? a : b;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] stairs = new int[N + 1];
        int[][] dp = new int[N + 1][2];


        for (int i = 1; i <= N; i++){
            stairs[i] = Integer.parseInt(br.readLine());
        }

        if (N == 1) {
            bw.write(stairs[1] + "");
            
            br.close();
            bw.flush();
            bw.close();
            return;
        }
        
        // 0 -> 1 step
        // 1 -> 2 step

        dp[1][0] = stairs[1];
        dp[1][1] = 0;

        dp[2][0] = stairs[2] + stairs[1];
        dp[2][1] = stairs[2];

        for (int i = 3; i <= N; i++) {
            dp[i][0] = dp[i - 1][1] + stairs[i];
            dp[i][1] = max(dp[i - 2][0], dp[i - 2][1])  + stairs[i];
        }

        bw.write(max(dp[N][0], dp[N][1]) + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
