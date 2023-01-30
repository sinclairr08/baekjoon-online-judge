import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();
        S = S.toUpperCase();
        int[] cnt = new int[26];

        for(int i = 0; i < S.length(); i++) {
           cnt[S.charAt(i) - 'A'] += 1;
        }

        int max_cnt = 0;
        char max_word = '?';

        for (int i = 0; i < 26; i++) {
            if (cnt[i] > max_cnt) {
                max_word = (char)((int)'A' + i);
                max_cnt = cnt[i];
            }
            else if (cnt[i] == max_cnt) {
                max_word = '?';
            }
        }

        bw.write(max_word);
        
        br.close();
        bw.flush();
        bw.close();
    }
    
}
