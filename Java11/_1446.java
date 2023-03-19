import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class _1446 {
    private static int read() throws IOException {
        int c, n = System.in.read() & 15;

        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }

        return n;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = read();
        int D = read();

        int[] dp = new int[D + 1];
        int[][] ways = new int[N][3];

        for (int i = 0; i < N; i++) {
            ways[i][0] = read();
            ways[i][1] = read();
            ways[i][2] = read();
        }

        for (int i = 1; i <= D; i++) {
            int optimal = dp[i - 1] + 1;

            for (int j = 0; j < N; j++) {
                if (ways[j][1] == i) {
                    optimal = Math.min(optimal, dp[ways[j][0]] + ways[j][2]);
                }
            }

            dp[i] = optimal;
        }

        bw.write(dp[D] + "");

        bw.flush();
        bw.close();
    }

}
