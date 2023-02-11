import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _10797 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0;

        while (st.hasMoreTokens()) {
            cnt += Integer.parseInt(st.nextToken()) == N ? 1 : 0;
        }

        bw.write(cnt + "");

        br.close();
        bw.flush();
        bw.close();
    }

}
