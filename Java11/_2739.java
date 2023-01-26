import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _2739 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= 9; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(N);
            sb.append(" * ");
            sb.append(i);
            sb.append(" = ");
            sb.append(N * i);
            sb.append("\n");

            bw.write(sb.toString());
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
    
}
