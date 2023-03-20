import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _7490 {
    public static StringBuilder sb = new StringBuilder();

    public static int calculate(char[] operators, int N) {
        int[] queue = new int[2 * N];
        int idx = 0;
        queue[idx] = 1;

        for (int i = 1; i < N; i++) {
            if (operators[i] == ' ') {
                queue[idx] = queue[idx] * 10 + (i + 1);
            } else if (operators[i] == '+') {
                queue[++idx] = -1;
                queue[++idx] = i + 1;
            } else {
                queue[++idx] = -2;
                queue[++idx] = i + 1;
            }
        }

        int result = queue[0];
        for (int j = 1; j <= idx; j++) {
            if (queue[j] == -1) {
                result += queue[++j];
            } else {
                result -= queue[++j];
            }
        }

        return result;

    }

    public static void dfs(int idx, int N, char[] operators) {
        if (idx == N) {
            if (calculate(operators, N) == 0) {
                for (int i = 1; i < N; i++) {
                    sb.append(i).append(operators[i]);
                }
                sb.append(N).append("\n");

            }
            return;
        }

        operators[idx] = ' ';
        dfs(idx + 1, N, operators);

        operators[idx] = '+';
        dfs(idx + 1, N, operators);

        operators[idx] = '-';
        dfs(idx + 1, N, operators);

        return;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            char[] operators = new char[N + 1];

            dfs(1, N, operators);
            sb.append("\n");

        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

}
