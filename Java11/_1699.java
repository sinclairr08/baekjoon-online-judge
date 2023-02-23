import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1699 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            int min = 100001;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(dp[i - (j * j)] + 1, min);
            }
            dp[i] = min;
        }

        bw.write(dp[N] + "");

        br.close();
        bw.flush();
        bw.close();
    }

}
