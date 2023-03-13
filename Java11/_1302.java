import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class _1302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> books = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            books.put(s, books.getOrDefault(s, 0) + 1);
        }

        int maxVal = 0;
        String s = "";

        for (Map.Entry<String, Integer> e : books.entrySet()) {
            if (e.getValue() > maxVal) {
                s = e.getKey();
                maxVal = e.getValue();
            } else if (e.getValue() == maxVal) {
                if (s.compareTo(e.getKey()) > 0) {
                    s = e.getKey();
                }
            }
        }

        bw.write(s);

        br.close();
        bw.flush();
        bw.close();
    }

}
