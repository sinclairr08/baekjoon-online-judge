import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _24431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numTest = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numTest; i++) {
            st = new StringTokenizer(br.readLine());
            int numWords = Integer.parseInt(st.nextToken());
            int lenWords = Integer.parseInt(st.nextToken());
            int lenPrefix = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            Map<String, Integer> map = new HashMap<>();

            for (int j = 0; j < numWords; j++) {
                String subs = st.nextToken().substring(lenWords - lenPrefix);
                map.put(subs, map.getOrDefault(subs, 0) + 1);
            }

            int result = 0;
            for (int v : map.values()) {
                result += v / 2;
            }

            sb.append(result).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

}
