import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _9997 {
    final static int MAX = (1 << 26) - 1;

    public static int N;
    public static int[] arr;

    public static int dfs(int idx, int curValue) {
        if (curValue == MAX) {
            return (1 << (N - idx));
        }

        if (idx == N) {
            return 0;
        }

        return dfs(idx + 1, curValue | arr[idx]) + dfs(idx + 1, curValue);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            int curNum = 0;

            for (int j = 0; j < s.length(); j++) {
                curNum |= 1 << (s.charAt(j) - 'a');
            }

            arr[i] = curNum;
        }

        bw.write(dfs(0, 0) + "");

        br.close();
        bw.flush();
        bw.close();
    }

}
