import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _13458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] tests = new int[N];

        for (int i = 0; i < N; i++) {
            tests[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        int mainD = Integer.parseInt(st.nextToken());
        int subD = Integer.parseInt(st.nextToken());

        long result = 0;

        for (int test : tests) {
            if (mainD >= test) {
                result += 1;
            } else {
                result += Math.ceil(((double) (test - mainD)) / subD) + 1;
            }
        }

        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }

}
