import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long[] fibos = new long[41];

        fibos[0] = 0;
        fibos[1] = 1;

        for (int n = 2; n < 41; n++) {
            fibos[n] = fibos[n - 1] + fibos[n - 2];
        }
        
        for (int i = 0; i < N; i++) {
            int idx = Integer.parseInt(br.readLine());
            bw.write((idx > 0 ? fibos[idx - 1] : 1) + " " + fibos[idx] + "\n");
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
    
}
