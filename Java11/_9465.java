import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int[][] dp = new int[2][100001];

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                dp[0][j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                dp[1][j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 2; j <= N; j++) {
                dp[0][j] += Math.max(dp[1][j - 1], dp[1][j - 2]);
                dp[1][j] += Math.max(dp[0][j - 1], dp[0][j - 2]);
            }
            sb.append(Math.max(dp[0][N], dp[1][N])).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

}
