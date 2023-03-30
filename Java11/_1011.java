import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1011 {
    public static int calculate(int N) {
        int sq = (int) Math.sqrt(N);

        if (N == sq * sq) {
            return 2 * sq - 1;
        } else if (N <= (sq * sq) + sq) {
            return 2 * sq;
        } else {
            return 2 * sq + 1;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());

            int end = Integer.parseInt(st.nextToken());
            sb.append(calculate(end - start)).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

}
