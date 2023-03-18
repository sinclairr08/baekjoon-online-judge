import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _27649 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        char c, prev = ' ';

        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);

            if (c == '<' || c == '>' || c == '(' || c == ')') {
                if (prev == ' ') {
                    sb.append(c).append(' ');
                } else {
                    sb.append(' ').append(c).append(' ');
                }
                prev = ' ';
            } else if (c == '&' || c == '|') {
                if (prev == ' ') {
                    sb.append(c).append(c).append(' ');
                } else {
                    sb.append(' ').append(c).append(c).append(' ');
                }
                prev = ' ';
                i += 1;
            } else if (c == ' ') {
                if (prev != ' ') {
                    sb.append(' ');
                }
                prev = c;
            } else {
                sb.append(c);
                prev = c;
            }
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

}
