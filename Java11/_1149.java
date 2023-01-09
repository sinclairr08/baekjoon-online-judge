import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1149 {
    public static int min(int a, int b) {
        return a < b ? a : b;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] costs = new int[N][3];
        int[][] dp = new int[N][3];

        for (int i = 0; i < N; i++){
            String[] nums = br.readLine().split(" ");

            costs[i][0] = Integer.parseInt(nums[0]);
            costs[i][1] = Integer.parseInt(nums[1]);
            costs[i][2] = Integer.parseInt(nums[2]);
        }

        dp[0] = costs[0];

        for (int i = 1; i < N; i++) {
            dp[i][0] = min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
            dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
            dp[i][2] = min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
        }

        bw.write(min(min(dp[N - 1][0], dp[N - 1][1]), dp[N - 1][2]) + "");
        
        br.close();
        bw.flush();
        bw.close();
    }
    
}
