import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class _2178 {
    public static void main(String[] args) throws IOException {
        class Pair {
            int x;
            int y;
            int depth;

            Pair(int x, int y, int depth) {
                this.x = x;
                this.y = y;
                this.depth = depth;
            }

            public Pair add(Pair d) {
                return new Pair(this.x + d.x, this.y + d.y, this.depth + 1);
            }

            public boolean isInside(int N, int M) {
                if (x >= N || y >= M || x < 0 || y < 0) {
                    return false;
                }
                return true;
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        Pair[] dirs = { new Pair(1, 0, 0), new Pair(-1, 0, 0), new Pair(0, 1, 0), new Pair(0, -1, 0) };

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j) & 15;
            }
        }

        Deque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(0, 0, 1));
        arr[0][0] = 0;

        int resultDepth = 1;

        while (queue.size() > 0) {
            Pair curPlace = queue.pollFirst();

            if (curPlace.x == (N - 1) && curPlace.y == (M - 1)) {
                resultDepth = curPlace.depth;
                break;
            }

            for (Pair d : dirs) {
                Pair newPlace = curPlace.add(d);

                if (!newPlace.isInside(N, M)) {
                    continue;
                }

                if (arr[newPlace.x][newPlace.y] == 0) {
                    continue;
                }

                arr[newPlace.x][newPlace.y] = 0;
                queue.add(newPlace);
            }

        }

        bw.write(resultDepth + "");

        br.close();
        bw.flush();
        bw.close();
    }

}
