import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _14889 {
    public static int[][] stats;
    public static int N;
    public static int minDiff = 200000;
    public static boolean[] teamStart;

    public static int calculateDiff() {
        int diff = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (teamStart[i] == true && teamStart[j] == true) {
                    diff += stats[i][j];
                } else if (teamStart[i] == false && teamStart[j] == false) {
                    diff -= stats[i][j];
                }
            }
        }

        return diff >= 0 ? diff : -diff;
    }

    public static void dfs(int idx, int startMem) {
        if (idx == N / 2) {
            minDiff = Math.min(calculateDiff(), minDiff);
            return;
        }

        for (int i = startMem; i < N; i++) {
            if (!teamStart[i]) {
                teamStart[i] = true;
                dfs(idx + 1, i + 1);
                teamStart[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        stats = new int[N][N];
        teamStart = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                stats[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        bw.write(minDiff + "");

        br.close();
        bw.flush();
        bw.close();
    }

}
