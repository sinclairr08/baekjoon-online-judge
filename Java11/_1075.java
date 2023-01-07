import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long N = Long.parseLong(br.readLine());
        long F = Long.parseLong(br.readLine());
        
        N -= N % 100;
        long result = N % F == 0 ? 0 : F - (N % F);

        bw.write((result < 10 ? "0" : "") + result);
        
        br.close();
        bw.flush();
        bw.close();
    }
    
}
