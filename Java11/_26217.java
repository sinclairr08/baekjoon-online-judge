import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class _26217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        if (N == 1) {
            bw.write(1.0 + "");
            br.close();
            bw.flush();
            bw.close();
            return;
        }

        int cnt = 1;
        double expectation = .0;
        double curVal = 1.0;

        double[] curProbs = new double[N + 1];
        double[] nextProbs = new double[N + 1];

        curProbs[1] = 1;

        while (cnt < 20 * N) {
            for(int i = 1; i < N; i++) {               
                nextProbs[i] += curProbs[i] * ((double)i / (double)N);
                nextProbs[i + 1] += curProbs[i] * ((double)(N - i) / (double)N);
            }

            curProbs = nextProbs.clone();
            Arrays.fill(nextProbs, .0);

            cnt++;
            curVal = (double)cnt * curProbs[N];
            expectation += curVal;
        }

        bw.write(expectation + "");

        br.close();
        bw.flush();
        bw.close();
    }
    
}
