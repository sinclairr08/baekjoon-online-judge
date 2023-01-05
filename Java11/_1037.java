import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1037 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] nums = br.readLine().split(" ");

        int maxDivisor = 0;
        int minDivisor = 10000001;

        for (int i = 0; i < N; i++){
            int cur = Integer.parseInt(nums[i]);
            if (cur < minDivisor) minDivisor = cur;
            if (cur > maxDivisor) maxDivisor = cur;
        }

        bw.write((minDivisor * maxDivisor) + "");

        br.close();
        bw.flush();
        bw.close();
    }
    
}
