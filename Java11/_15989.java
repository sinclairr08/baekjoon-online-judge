import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _15989 {
    public static int[][] dp = new int[10001][4];
    public static int calcIdx = 3;

    public static void calcNums(int idx) {
        while (calcIdx < idx) {
            calcIdx += 1;

            dp[calcIdx][1] = dp[calcIdx - 1][1];
            dp[calcIdx][2] = dp[calcIdx - 2][1] + dp[calcIdx - 2][2];
            dp[calcIdx][3] = dp[calcIdx - 3][1] + dp[calcIdx - 3][2] + dp[calcIdx - 3][3];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            calcNums(x);
            sb.append(dp[x][1] + dp[x][2] + dp[x][3]).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

}
