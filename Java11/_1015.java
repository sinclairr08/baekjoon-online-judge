import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");

        int[] nums = new int[N];
        int[] results = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(line[i]);
        }

        int idx = 0;
        for (int val = 1; val <= 1000; val++) {
            for (int i = 0; i < N; i++) {
                if (nums[i] == val) {
                    results[i] = idx++;
                }
            }

            if (idx == N) break;
        }

        for (int i = 0; i < N; i++) {
            bw.write(results[i] + " ");
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
    
}
