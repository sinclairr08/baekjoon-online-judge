import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1152 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0;

        while (st.hasMoreTokens()) {
            st.nextToken();
            cnt += 1;
        }
               
        bw.write(cnt + "");
        bw.flush();

        br.close();
        bw.close();
    }
    
}
