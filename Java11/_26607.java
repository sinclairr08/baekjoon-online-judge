import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _26607 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] infos = br.readLine().split(" ");

        int N = Integer.parseInt(infos[0]);
        int K = Integer.parseInt(infos[1]);
        int x = Integer.parseInt(infos[2]);

        int[] powers = new int[N];
        boolean[][] dp = new boolean[x * K + 1][K + 1];

        for(int i = 0; i < N; i++) {
            String[] nums = br.readLine().split(" ");
            powers[i] =  Integer.parseInt(nums[0]);
        }

        for (int i = 0; i <= x * K; i++){
            dp[i] = new boolean[K + 1];
        }

        for (int p: powers) {
            for (int i = x * K; i >= p; i--) {
                for (int n_members = K - 1; n_members >= 1; n_members--) {
                    dp[i][n_members + 1] = dp[i][n_members + 1] || dp[i - p][n_members];
                }
            }
            dp[p][1] = true;
        }

        int optimal_power_1 = (K * x) / 2 + (K * x) % 2;
        int optimal_power_2 = (K * x) / 2; 


        while (optimal_power_2 > 0) {
            if(dp[optimal_power_1][K]) break;
            if(dp[optimal_power_2][K]) break;

            optimal_power_1 += 1;
            optimal_power_2 -= 1;
        }

        bw.write((optimal_power_1 * optimal_power_2) + "");
        
        br.close();
        bw.flush();
        bw.close();
    }
    
}
