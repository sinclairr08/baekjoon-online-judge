import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class _1141 {
    /**
     * 
     * @param s1
     * @param s2
     * @return s1이 s2의 접두사인 경우 true, 아닌 경우 false
     */
    public static boolean isAhead(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        Arrays.sort(words);

        int result = N;

        for (int i = 1; i < N; i++) {
            if (isAhead(words[i - 1], words[i])) {
                result--;
            }
        }

        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }

}
