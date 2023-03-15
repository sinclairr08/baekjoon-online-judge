import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _1351 {
    public static Map<Long, Long> memo = new HashMap<>();
    public static long P;
    public static long Q;

    public static long dfs(long N) {
        if (N == 0) {
            return 1;
        }

        long result = memo.getOrDefault(N, 0L);
        if (result != 0L) {
            return result;
        }

        result = dfs(N / P) + dfs(N / Q);
        memo.put(N, result);
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());

        bw.write(dfs(N) + "");

        br.close();
        bw.flush();
        bw.close();
    }

}
