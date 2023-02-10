import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _2753 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int isYoon = N % 400 == 0 ? 1 : (N % 100 == 0 ? 0 : (N % 4 == 0 ? 1 : 0));

        bw.write(isYoon + "");

        br.close();
        bw.flush();
        bw.close();
    }

}
