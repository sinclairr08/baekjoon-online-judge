import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int counts[] = new int[12];

        counts[1] = 1;
        counts[2] = 2;
        counts[3] = 4;

        for (int i = 4; i < 12; i++) {
            counts[i] = counts[i - 1] + counts[i - 2] + counts[i - 3];
        }

        for (int i = 0; i < N; i++){
            int idx = Integer.parseInt(br.readLine());
            bw.write(counts[idx] + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
    
}
