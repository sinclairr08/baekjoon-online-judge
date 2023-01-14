import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] memos = new int[N + 1];
      
        for (int i = 2; i <= N; i++) {
            int min_calc = memos[i - 1];
            if (i % 2 == 0 && memos[i / 2] < min_calc) {
                min_calc = memos[i / 2];
            }
            if (i % 3 == 0 && memos[i / 3] < min_calc) {
                min_calc = memos[i / 3];
            }

            memos[i] = min_calc + 1;
        }
        
        bw.write(memos[N] + "\n");
        
        br.close();
        bw.flush();
        bw.close();
    }
    
}
