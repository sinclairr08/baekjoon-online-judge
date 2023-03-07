import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        long result = 1;

        // a^b를 a^(2^i)들로 쪼개서 곱하는 방법
        // a를 매 번 제곱해 줌
        while (b != 0) {
            if (b % 2 == 1) {
                result = (result * a) % c;
            }
            a = (a * a) % c;
            b /= 2;
        }

        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }

}
