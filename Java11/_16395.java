import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _16395 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nums = br.readLine().split(" ");

        int N = Integer.parseInt(nums[0]);
        int K = Integer.parseInt(nums[1]);

        N -= 1;
        K -= 1;

        if (K > N / 2) {
            K = N - K;
        }

        long result = 1;
        for (int i = 0; i < K; i++) {
            result *= (long) (N - i);
            result /= (long) (i + 1);
        }

        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }

}
