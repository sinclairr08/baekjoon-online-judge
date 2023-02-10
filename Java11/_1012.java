import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class _1012 {
    public static void main(String[] args) throws IOException {
        class Pair {
            int x;
            int y;

            Pair(int x, int y) {
                this.x = x;
                this.y = y;
            }

            Pair add(Pair n) {
                return new Pair(this.x + n.x, this.y + n.y);
            }

            boolean isInsideBoundary(int rowSize, int colSize) {
                if (this.x < 0 || this.y < 0 || this.x >= rowSize || this.y >= colSize) {
                    return false;
                }
                return true;
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final Pair[] dirs = { new Pair(0, 1), new Pair(1, 0), new Pair(0, -1), new Pair(-1, 0) };

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int rowSize, colSize, numCab, x, y;

        for (int testIdx = 0; testIdx < T; testIdx++) {
            st = new StringTokenizer(br.readLine());

            rowSize = Integer.parseInt(st.nextToken());
            colSize = Integer.parseInt(st.nextToken());
            numCab = Integer.parseInt(st.nextToken());

            boolean[][] cabbage = new boolean[rowSize][colSize];

            for (int cab = 0; cab < numCab; cab++) {
                st = new StringTokenizer(br.readLine());

                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());

                cabbage[x][y] = true;
            }

            Deque<Pair> queue = new ArrayDeque<>();
            Pair current, next;
            int cnt = 0;

            for (int i = 0; i < rowSize; i++) {
                for (int j = 0; j < colSize; j++) {
                    if (!cabbage[i][j]) {
                        continue;
                    }

                    cnt += 1;
                    queue.add(new Pair(i, j));

                    while (queue.size() > 0) {
                        current = queue.pollFirst();
                        for (Pair d : dirs) {
                            next = current.add(d);
                            if (!next.isInsideBoundary(rowSize, colSize) || !cabbage[next.x][next.y])
                                continue;

                            cabbage[next.x][next.y] = false;
                            queue.add(next);
                        }
                    }
                }
            }

            bw.write(cnt + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

}
