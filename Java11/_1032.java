import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1032 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String words[] = new String[N];

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        for (int j = 0; j < words[0].length(); j++) {
            int i;
            for (i = 1; i < N; i++) {
                if (words[0].charAt(j) != words[i].charAt(j)) {
                    bw.write("?");
                    break;
                }
            }

            if (i == N) {
                bw.write(words[0].charAt(j));
            }

        }

        br.close();
        bw.flush();
        bw.close();
    }
    
}
