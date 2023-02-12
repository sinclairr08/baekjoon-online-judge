import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _9084 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int numCoins;
        int target;
        StringTokenizer st;

        for (int t = 0; t < T; t++) {
            numCoins = Integer.parseInt(br.readLine());
            int[] coins = new int[numCoins + 1];
            st = new StringTokenizer(br.readLine());

            for (int i = 1; i <= numCoins; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }

            target = Integer.parseInt(br.readLine());

            // dp[N] : N원을 만드는 경우의 수를 1d knapsack으로
            int[] dp = new int[target + 1];
            dp[0] = 1;

            for (int i = 1; i <= numCoins; i++) {
                int curCoin = coins[i];
                // j원을 만들기 위해서는 다음 두개를 더하면 됨
                // 1. dp[j]의 이전 값: M - 1 개까지만 사용해 j원을 만드는 가짓수
                // 2. dp[j - curCoin]: M개까지 사용해 j - curCoin원을 만드는 가짓수
                // j가 오름차순으로 증가하기 때문에 가능
                for (int j = curCoin; j <= target; j++) {
                    dp[j] += dp[j - curCoin];
                }
            }

            bw.write(dp[target] + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

}
