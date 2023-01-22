import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

class retClass {
    public boolean isOK;
    public Deque<Integer> queue = new ArrayDeque<>();

    retClass(boolean isOK) {
        this.isOK = isOK;
    }
}

public class _10597 {
    public static int getNFromLength(int length) {
        // N이 1 ~ 9 => length == N
        if (length < 10)  return length;

        // N이 10 ~ 50 => length == 9 + 2(N - 9) == 2N - 9
        else return (length + 9) / 2;

    }

    public static retClass dfs(String s, boolean[] visited, int N, int depth) {
        if (depth == s.length()) {
            return new retClass(true);
        }


        retClass result = new retClass(false);
        int curN = Integer.parseInt(s.substring(depth, depth + 1));

        if (curN <= N && !visited[curN]) {
            visited[curN] = true;
            result = dfs(s, visited, N, depth + 1);
            visited[curN] = false;

            if (result.isOK) {
                result.queue.addFirst(curN);
                return result;
            }
        }

        if (depth + 2 > s.length()) {
            return result;
        }

        curN = Integer.parseInt(s.substring(depth, depth + 2));
        if (curN <= N && !visited[curN]) {
            visited[curN] = true;
            result = dfs(s, visited, N, depth + 2);
            visited[curN] = false;
        }

        if (result.isOK) {
            result.queue.addFirst(curN);
        }

        return result;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int N = getNFromLength(s.length());
        boolean[] visited = new boolean[N + 1];

        Deque<Integer> queue = dfs(s, visited, N, 0).queue;

        for (int q: queue) {
            bw.write(q + " ");
        }
        br.close();
        bw.flush();
        bw.close();
    }
    
}
