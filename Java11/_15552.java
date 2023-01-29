import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _15552 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] nums = br.readLine().split(" ");

            int a = Integer.parseInt(nums[0]);
            int b = Integer.parseInt(nums[1]);

            bw.write((a + b) + "\n");
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
    
}
