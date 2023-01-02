import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1037 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numDivisor = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int maxDivisor = 0;
        int minDivisor = 10000001;

        for (int i = 0; i < numDivisor; i++){
            int cur = Integer.parseInt(st.nextToken());
            if (cur < minDivisor) minDivisor = cur;
            if (cur > maxDivisor) maxDivisor = cur;
        }

        bw.write((minDivisor * maxDivisor) + "\n");
        bw.flush();

        br.close();
        bw.close();
    }
    
}
