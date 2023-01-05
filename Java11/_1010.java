import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N_test = Integer.parseInt(br.readLine());

        int N, M;
        long result;

        for (int i = 0; i < N_test; i++) {
            String[] line = br.readLine().split(" ");

            N = Integer.parseInt(line[0]);
            M = Integer.parseInt(line[1]);

            result = 1;

            if (N > M / 2) N = M - N;

            for (int j = 0; j < N; j++) {
                result *= (M - j);
                result /= (j + 1);
            }

            bw.write(result + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
    
}
