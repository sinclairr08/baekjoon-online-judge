import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _2037 {
    public static char startChar(char c) {
        char[] startChars = { 'A', 'D', 'G', 'J', 'M', 'P', 'T', 'W' };

        for (int i = 1; i < 8; i++) {
            if (c < startChars[i]) {
                return startChars[i - 1];
            }
        }

        return startChars[7];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int buttonClick = Integer.parseInt(st.nextToken());
        int buttonWait = Integer.parseInt(st.nextToken());
        int result = 0;

        String s = br.readLine();
        char c;
        char[] starts = new char[s.length()];

        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);

            if (c == ' ') {
                result += buttonClick;
            }

            else {
                starts[i] = startChar(c);

                if (i > 0 && starts[i] == starts[i - 1]) {
                    result += buttonWait;
                }

                result += (c - starts[i] + 1) * buttonClick;
            }

        }

        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }

}
