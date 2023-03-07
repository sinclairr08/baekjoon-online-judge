import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1182 {
    public static int[] arr = new int[20];
    public static int N;
    public static int S;

    public static int dfs(int idx, int curSum) {
        int numAnswer = 0;

        for (int i = idx; i < N; i++) {
            if (curSum + arr[i] == S) {
                numAnswer++;
            }
            numAnswer += dfs(i + 1, curSum + arr[i]);
        }

        return numAnswer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(dfs(0, 0) + "");

        br.close();
        bw.flush();
        bw.close();
    }

}
