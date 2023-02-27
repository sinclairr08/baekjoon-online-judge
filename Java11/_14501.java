import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _14501 {
    public static int N;
    public static int[] times = new int[15];
    public static int[] rewards = new int[15];
    public static int[] dp = new int[15];

    public static int dfs(int day) {
        // Exceeds day
        if (day >= N) {
            return 0;
        }

        // If already visited
        if (dp[day] != 0) {
            return dp[day];
        }

        // If working today is not available
        if (day + times[day] > N) {
            dp[day] = dfs(day + 1);
            return dp[day];
        }

        int useToday = dfs(day + times[day]) + rewards[day];
        int passToday = dfs(day + 1);

        dp[day] = Math.max(useToday, passToday);
        return dp[day];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            times[i] = Integer.parseInt(st.nextToken());
            rewards[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(dfs(0) + "");

        br.close();
        bw.flush();
        bw.close();
    }

}
