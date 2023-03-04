import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _5585 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] moneys = { 500, 100, 50, 10, 5, 1 };
        int cnt = 0, curCnt;

        for (int idx = 0; N < 1000; idx++) {
            if (moneys[idx] + N <= 1000) {
                curCnt = (1000 - N) / moneys[idx];

                N += curCnt * moneys[idx];
                cnt += curCnt;
            }
        }

        bw.write(cnt + "");

        br.close();
        bw.flush();
        bw.close();
    }

}
