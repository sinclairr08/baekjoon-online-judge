import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> nameToNum = new HashMap<>();
        String[] numToName = new String[N + 1];

        for (int i = 1; i <= N; i++) {
            String s = br.readLine();

            nameToNum.put(s, i);
            numToName[i] = s;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= M; i++) {
            String q = br.readLine();

            if (q.charAt(0) >= 'A') {
                sb.append(nameToNum.get(q)).append("\n");
            } else {
                sb.append(numToName[Integer.parseInt(q)]).append("\n");
            }
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

}
