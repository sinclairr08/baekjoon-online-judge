import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class _10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        String s;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            s = st.nextToken();

            if (s.equals("push")) {
                stack.add(Integer.parseInt(st.nextToken()));
            } else if (s.equals("pop")) {
                sb.append(stack.isEmpty() ? -1 : stack.pollLast()).append("\n");
            } else if (s.equals("size")) {
                sb.append(stack.size()).append("\n");
            } else if (s.equals("empty")) {
                sb.append(stack.isEmpty() ? 1 : 0).append("\n");
            } else if (s.equals("top")) {
                sb.append(stack.isEmpty() ? -1 : stack.peekLast()).append("\n");
            }
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

}
