import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nums = br.readLine().split(" ");

        int N = Integer.parseInt(nums[0]);
        int[] coins = new int[N];
        int target = Integer.parseInt(nums[1]);
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int idx = N - 1;
        while(target > 0) {
            cnt += target / coins[idx];
            target = target % coins[idx];
            idx--;
        }

        bw.write(cnt + "");
        
        br.close();
        bw.flush();
        bw.close();
    }
    
}
