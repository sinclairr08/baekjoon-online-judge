import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1024 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nums = br.readLine().split(" ");

        int N = Integer.parseInt(nums[0]);
        int L = Integer.parseInt(nums[1]);
        int startNum = -1;
        int numer, denom;

        while (L <= 100) {
            numer = 2 * N - (L * L) + L;
            denom = 2 * L;
            if (numer >= 0 && numer % denom == 0) {
                startNum = numer / denom;
                break;
            }
            L++;
        }

        if (startNum == -1) {
            bw.write(startNum + "");
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < L; i++) {
                sb.append(startNum + i).append(" ");
            }
            bw.write(sb.toString());
        }

        br.close();
        bw.flush();
        bw.close();
    }

}
