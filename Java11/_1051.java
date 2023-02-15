import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1051 {
    public static int min(int x, int y) {
        return x < y ? x : y;
    }

    public static int max(int x, int y) {
        return x > y ? x : y;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nums = br.readLine().split(" ");

        int N = Integer.parseInt(nums[0]);
        int M = Integer.parseInt(nums[1]);

        String line;
        char[][] arr = new char[N][M];

        for (int i = 0; i < N; i++) {
            line = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        int globalMaxSize = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int maxSize = min(N - i, M - j);
                char curVal = arr[i][j];
                for (int curSize = 1; curSize < maxSize; curSize++) {
                    if (curVal == arr[i][j + curSize] && curVal == arr[i + curSize][j]
                            && curVal == arr[i + curSize][j + curSize]) {
                        globalMaxSize = max(globalMaxSize, curSize);
                    }
                }
            }
        }

        bw.write(((globalMaxSize + 1) * (globalMaxSize + 1)) + "");

        br.close();
        bw.flush();
        bw.close();
    }

}
