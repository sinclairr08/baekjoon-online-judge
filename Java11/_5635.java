import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class _5635 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Map<Integer, String> births = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            int birth = 0;

            birth += Integer.parseInt(st.nextToken());
            birth += Integer.parseInt(st.nextToken()) * 100;
            birth += Integer.parseInt(st.nextToken()) * 10000;

            births.put(birth, name);
        }

        List<Integer> keys = new ArrayList<>(births.keySet());
        Collections.sort(keys);

        bw.write(births.get(keys.get(keys.size() - 1)));
        bw.newLine();
        bw.write(births.get(keys.get(0)));

        br.close();
        bw.flush();
        bw.close();
    }

}
