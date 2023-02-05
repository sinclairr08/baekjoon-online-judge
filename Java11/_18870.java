import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class _18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        Map<Integer, Integer> compress = new HashMap<>();
        Set<Integer> sorted = new TreeSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sorted.add(arr[i]);
        }

        int idx = 0;
        for (int s: sorted) {
            compress.put(s, idx++);
        }

        for(int i = 0; i < N; i++) {
            sb.append(compress.get(arr[i])).append(" ");
        }

        bw.write(sb.toString());
       
        br.close();
        bw.flush();
        bw.close();
    }
    
}
