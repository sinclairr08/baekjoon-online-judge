import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _11653 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int div = 2;
        StringBuilder sb = new StringBuilder();

        while (N > 1) {
            while (N % div == 0) {
                sb.append(div);
                sb.append("\n");

                N /= div;
            }

            div += div == 2 ? 1 : 2;
        }

        bw.write(sb.toString());
        
        br.close();
        bw.flush();
        bw.close();
    }
    
}
