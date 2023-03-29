import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class _21922 {
    static class Cell {
        int state;
        boolean[] visited = new boolean[4];
        boolean counted;

        Cell(int state) {
            this.state = state;
            this.counted = false;
        }

        void useDirection(int d) {
            this.visited[d] = true;
        }

        void count() {
            this.counted = true;
        }
    }

    static class Wind {
        int x;
        int y;
        int dir;

        Wind(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        public Wind generateNext() {
            if (this.dir == 0) {
                return new Wind(this.x - 1, this.y, this.dir);
            } else if (this.dir == 1) {
                return new Wind(this.x, this.y + 1, this.dir);
            } else if (this.dir == 2) {
                return new Wind(this.x + 1, this.y, this.dir);
            } else {
                return new Wind(this.x, this.y - 1, this.dir);
            }
        }

        /**
         * 0 -> up
         * 1 -> right
         * 2 -> down
         * 3 -> left
         */

        public void changeWind(int state) {
            switch (state) {
                case 0:
                case 9:
                    break;
                case 1:
                    if (this.dir % 2 == 1) {
                        this.dir = (this.dir + 2) % 4;
                    }
                    break;
                case 2:
                    if (this.dir % 2 == 0) {
                        this.dir = (this.dir + 2) % 4;
                    }
                    break;
                case 3:
                    this.dir = (5 - this.dir) % 4;
                    break;
                case 4:
                    this.dir = (3 - this.dir) % 4;
                    break;
                default:
                    break;
            }
        }

        public boolean isInside(int N, int M) {
            if (this.x >= N || this.x < 0 || this.y >= M || this.y < 0) {
                return false;
            }
            return true;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Cell[][] arr = new Cell[N][M];
        Deque<Wind> queue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int state = Integer.parseInt(st.nextToken());
                arr[i][j] = new Cell(state);

                if (state == 9) {
                    for (int d = 0; d < 4; d++) {
                        queue.add(new Wind(i, j, d));
                        arr[i][j].useDirection(d);
                    }
                    arr[i][j].count();
                }
            }
        }

        while (queue.size() > 0) {
            Wind curWind = queue.pollFirst();
            Wind nextWind = curWind.generateNext();

            if (nextWind.isInside(N, M)) {
                Cell curCell = arr[nextWind.x][nextWind.y];
                nextWind.changeWind(curCell.state);

                if (curCell.visited[nextWind.dir]) {
                    continue;
                }

                curCell.count();
                curCell.useDirection(nextWind.dir);

                queue.add(nextWind);
            }

        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                result += arr[i][j].counted ? 1 : 0;
            }
        }
        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }

}
