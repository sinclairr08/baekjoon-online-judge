import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int cnt = N / 5;

        N -= cnt * 5;

        // 5x + 1 -> 5(x - 1) + 3 * 2
        if (N == 1 && cnt >= 1) {
            cnt += 1;
            N = 0;
        }
        // 5x + 2 -> 5(x - 2) + 3 * 4
        else if (N == 2 && cnt >= 2) {
            cnt += 2;
            N = 0;
        }
        // 5x + 3 -> 5x + 3 * 1
        else if (N == 3) {
            cnt += 1;
            N = 0;
        }
        // 5x + 4 -> 5(x - 1) + 3 * 3
        else if (N == 4 && cnt >= 1) {
            cnt += 2;
            N = 0;
        }     

        bw.write((N == 0 ? cnt : -1) + "");
        
        br.close();
        bw.flush();
        bw.close();
    }
    
}
