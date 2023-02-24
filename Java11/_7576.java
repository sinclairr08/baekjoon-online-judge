import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class _7576 {
    public static boolean isTomatoRipped(int[][] arr, int x, int y) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (arr[i][j] == 0)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        class Pair {
            int x;
            int y;
            int time;

            Pair(int x, int y, int t) {
                this.x = x;
                this.y = y;
                this.time = t;
            }

            Pair add(Pair p) {
                return new Pair(this.x + p.x, this.y + p.y, this.time + 1);
            }

            boolean isValid(int xSize, int ySize) {
                if (this.x < 0 || this.x >= xSize || this.y < 0 || this.y >= ySize)
                    return false;
                return true;
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        final Pair[] dirs = { new Pair(0, 1, 0), new Pair(0, -1, 0), new Pair(1, 0, 0), new Pair(-1, 0, 0) };
        Deque<Pair> queue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    queue.add(new Pair(i, j, 0));
                }
            }
        }

        Pair current = new Pair(-1, -1, 0);
        Pair next;

        while (queue.size() > 0) {
            current = queue.pollFirst();

            for (Pair dir : dirs) {
                next = current.add(dir);

                if (next.isValid(N, M) && arr[next.x][next.y] == 0) {
                    arr[next.x][next.y] = 1;
                    queue.add(next);
                }
            }
        }

        if (isTomatoRipped(arr, N, M)) {
            bw.write(current.time + "");
        } else {
            bw.write("-1");
        }

        br.close();
        bw.flush();
        bw.close();
    }

}
