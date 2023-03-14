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

public class _4358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = 0;
        String s;
        Map<String, Integer> woods = new HashMap<>();

        while ((s = br.readLine()) != null) {
            woods.put(s, woods.getOrDefault(s, 0) + 1);
            cnt++;
        }

        List<String> sortedKeys = new ArrayList<>(woods.keySet());
        Collections.sort(sortedKeys);

        StringBuilder sb = new StringBuilder();

        for (String k : sortedKeys) {
            double percent = (100.0 * (double) woods.get(k)) / cnt;
            sb.append(k).append(" ").append(String.format("%.4f", percent)).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

}
