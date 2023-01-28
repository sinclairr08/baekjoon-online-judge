import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int DIVIDER = 10007;
        int N = Integer.parseInt(br.readLine());

        int prev = 1;
        int result = 1;
        int temp;

        for (int i = 1; i < N; i++) {
            temp = result;
            result = (result + prev) % DIVIDER;
            prev = temp;
        }

        bw.write(result + "");
        
        br.close();
        bw.flush();
        bw.close();
    }
    
}
