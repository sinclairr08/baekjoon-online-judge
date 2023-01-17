import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _10872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long result = 1L;

        for(long i = 1; i <= (long)N; i++) {
            result *= i;
        }

        bw.write(result + "");
        
        br.close();
        bw.flush();
        bw.close();
    }
    
}
