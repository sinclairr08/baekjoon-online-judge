import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _14888 {
    public static int N;
    public static int[] nums = new int[11];
    public static int[] operations = new int[4];
    public static int globalMax = -1000000001;
    public static int globalMin = 1000000001;

    public static void dfs(int idx, int prev) {
        if (idx == N - 1) {
            if (prev > globalMax) {
                globalMax = prev;
            }
            if (prev < globalMin) {
                globalMin = prev;
            }
        }

        if (operations[0] > 0) {
            operations[0] -= 1;
            dfs(idx + 1, prev + nums[idx + 1]);
            operations[0] += 1;
        }
        if (operations[1] > 0) {
            operations[1] -= 1;
            dfs(idx + 1, prev - nums[idx + 1]);
            operations[1] += 1;
        }
        if (operations[2] > 0) {
            operations[2] -= 1;
            dfs(idx + 1, prev * nums[idx + 1]);
            operations[2] += 1;
        }
        if (operations[3] > 0) {
            operations[3] -= 1;
            dfs(idx + 1, prev / nums[idx + 1]);
            operations[3] += 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operations[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, nums[0]);

        bw.write(globalMax + "\n" + globalMin);

        br.close();
        bw.flush();
        bw.close();
    }

}
