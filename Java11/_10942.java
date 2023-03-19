import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class _10942 {
    public static int N;
    public static int[] arr;
    public static byte dp[][];

    public static byte findPalindrome(int start, int end) {
        if (dp[start][end] != 0) {
            return dp[start][end];
        }

        if (arr[start] != arr[end]) {
            dp[start][end] = -1;
            return -1;
        }

        if (start + 1 > end - 1) {
            dp[start][end] = 1;
            return 1;
        }
        // start + 1 <= end - 1
        else {
            dp[start][end] = findPalindrome(start + 1, end - 1);
            return dp[start][end];
        }
    };

    private static int read() throws IOException {
        int number = System.in.read() & 15; // Change Ascii to Integer

        int reader;
        while ((reader = System.in.read()) > 32) {
            number = (number << 3) + (number << 1) + (reader & 15);
        }

        return number;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = read();
        arr = new int[N + 1];
        dp = new byte[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = read();
            dp[i][i] = 1;
        }

        int M = read();
        int start, end;
        byte result;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            start = read();
            end = read();

            result = findPalindrome(start, end);
            sb.append(result == 1 ? 1 : 0).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}
