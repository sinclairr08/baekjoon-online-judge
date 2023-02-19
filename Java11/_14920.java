import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _14920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int collatz = Integer.parseInt(br.readLine());
        int cnt = 1;

        while (collatz != 1) {
            collatz = collatz % 2 == 0 ? collatz / 2 : (collatz * 3) + 1;
            cnt++;
        }

        bw.write(cnt + "");

        br.close();
        bw.flush();
        bw.close();
    }

}
