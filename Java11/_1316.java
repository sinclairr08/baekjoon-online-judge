import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1316 {
    public static boolean isGroup(String s) {
        boolean[] isUsed = new boolean[26];
        char prev = ' ', current;

        for (int i = 0; i < s.length(); i++) {
            current = s.charAt(i);

            if (current != prev) {
                if (isUsed[current - 'a']) {
                    return false;
                }
                isUsed[current - 'a'] = true;
                prev = current;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            result += isGroup(s) ? 1 : 0;
        }

        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }

}
