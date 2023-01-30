import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nums = br.readLine().split(" ");
        Map<String, Integer> DeduBo = new HashMap<>();
        List<String> result = new ArrayList<>();

        int N = Integer.parseInt(nums[0]);
        int M = Integer.parseInt(nums[1]);

        String s;
        for (int i = 0; i < N; i++) {
            s = br.readLine();
            DeduBo.put(s, 1);
        }

        for (int i = 0; i < M; i++) {
            s = br.readLine();
            if (DeduBo.get(s) != null) {
                DeduBo.put(s, 2);
            }
        }

        for (Map.Entry<String, Integer> item: DeduBo.entrySet()){
            if (item.getValue() == 2) {
                result.add(item.getKey());
            }
        }

        result.sort(Comparator.naturalOrder());
        
        bw.write(result.size() + "\n");
        
        for (String r: result) {
            bw.write(r);
            bw.newLine();
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
    
}
