import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nums = br.readLine().split(" ");

        int N = Integer.parseInt(nums[0]);
        int M = Integer.parseInt(nums[1]);
        
        String[] s_vals = br.readLine().split(" ");
        int[] vals = new int[N];

        for(int i = 0; i < N; i++) {
            vals[i] = Integer.parseInt(s_vals[i]);
        }

        int val1, val2, val3, sum;
        int closest = 0;

        for(int i = 0; i < N; i++) {
            val1 = vals[i];
            if (val1 >= M) continue;

            for(int j = i + 1; j < N; j++) {
                val2 = vals[j];
                if (val1 + val2 >= M) continue;

                for(int k = j + 1; k < N; k++) {
                    val3 = vals[k];
                    sum = val1 + val2 + val3;
                    if (sum > M) continue;

                    if (sum > closest) closest = sum;
                }
            }
        }

        bw.write(closest + "");

        br.close();
        bw.flush();
        bw.close();
    }
    
}
