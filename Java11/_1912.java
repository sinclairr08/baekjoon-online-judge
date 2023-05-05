import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dp = new int[N];
        int current = 0;
        int max = Integer.MIN_VALUE;

        dp[0] = Integer.parseInt(st.nextToken());
        max = Math.max(max, dp[0]);

        for (int i = 1; i < N; i++) {
            current = Integer.parseInt(st.nextToken());
            dp[i] = current + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }

        bw.write(max + "");

        br.close();
        bw.flush();
        bw.close();
    }

}
