import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1152 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] words = br.readLine().split(" ");
        int cnt = 0;

        for (String w: words) {
            cnt += w.length() > 0 ? 1 : 0;
        }

        bw.write(cnt + "");
        
        br.close();
        bw.flush();
        bw.close();
    }
    
}
