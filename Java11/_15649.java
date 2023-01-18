import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class _15649 {
    static boolean[] visited;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void dfs(int N, int depth, ArrayList<Integer> store) throws IOException {
        if (depth == 0) {
            for (int s: store) {
                bw.write(s + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                store.add(i);
                dfs(N, depth - 1, store);
                store.remove(store.size() - 1);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nums = br.readLine().split(" ");

        int N = Integer.parseInt(nums[0]);
        int M = Integer.parseInt(nums[1]);
        ArrayList<Integer> store = new ArrayList<>();

        visited = new boolean[N + 1];

        dfs(N, M, store);
        
        br.close();
        bw.flush();
        bw.close();
    }
    
}
