import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _10103 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int first = 100;
        int second = 100;

        StringTokenizer st;

        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (x > y) {
                second -= x;
            } else if (x < y) {
                first -= y;
            }
        }

        bw.write(first + "\n" + second);

        br.close();
        bw.flush();
        bw.close();
    }

}
