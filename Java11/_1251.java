import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _1251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int N = s.length();
        List<String> words = new ArrayList<>();

        for (int i = 1; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                StringBuilder word = new StringBuilder();
                word.append(new StringBuilder(s.substring(0, i)).reverse());
                word.append(new StringBuilder(s.substring(i, j)).reverse());
                word.append(new StringBuilder(s.substring(j)).reverse());

                words.add(word.toString());
            }
        }

        Collections.sort(words);
        bw.write(words.get(0));

        br.close();
        bw.flush();
        bw.close();
    }

}
