import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _2670 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        double[] arr = new double[N + 1];

        // dp[i] => i 번째 값이 마지막인 연속부분 최대곱
        double[] dp = new double[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }

        double max = 0.0;
        double current;

        for (int i = 1; i <= N; i++) {
            current = arr[i];

            // i - 1번째 값이 마지막인 연속부분 최대곱 * i번째 값 vs i 번째 값
            // 위 두 값 중 더 큰 값이 i번째 값이 마지막인 연속부분 최대곱
            dp[i] = dp[i - 1] * current > current ? dp[i - 1] * current : current;

            // max는 이러한 dp[i] 중 최댓값 (단, 0으로만 이루어진 경우는 제외)
            max = dp[i] > max ? dp[i] : max;
        }

        bw.write(String.format("%.3f", max));

        br.close();
        bw.flush();
        bw.close();
    }

}
