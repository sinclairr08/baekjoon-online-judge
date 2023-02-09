import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _14503 {
    // Rotate left, 3 -> 2 -> 1 -> 0
    public static int changeDirection(int dir) {
        return (dir + 3) % 4;
    }

    // Get opposite Direction, 3 -> 1 -> 3, 2 -> 0 -> 2
    public static int oppositeDirection(int dir) {
        return (dir + 2) % 4;
    }

    public static void main(String[] args) throws IOException {
        class Pair {
            int x;
            int y;

            Pair(int x, int y) {
                this.x = x;
                this.y = y;
            }

            Pair moveDirection(int dir) {
                if (dir == 0) {
                    return new Pair(this.x - 1, this.y);
                } else if (dir == 1) {
                    return new Pair(this.x, this.y + 1);
                } else if (dir == 2) {
                    return new Pair(this.x + 1, this.y);
                } else {
                    return new Pair(this.x, this.y - 1);
                }
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int rowSize = Integer.parseInt(st.nextToken());
        int colSize = Integer.parseInt(st.nextToken());

        int[][] arr = new int[rowSize][colSize];
        st = new StringTokenizer(br.readLine());

        Pair current = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        int curDir = Integer.parseInt(st.nextToken());

        for (int i = 0; i < rowSize; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < colSize; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cleanCnt = 0;
        int placeCnt;
        boolean isClean = true;
        Pair next = new Pair(0, 0);

        while (isClean) {
            if (arr[current.x][current.y] == 0) {
                cleanCnt += 1;
                arr[current.x][current.y] = -1;
            }

            for (placeCnt = 0; placeCnt < 4; placeCnt++) {
                curDir = changeDirection(curDir);
                next = current.moveDirection(curDir);
                if (arr[next.x][next.y] == 0)
                    break;
            }

            // If there is a place to clean
            if (placeCnt != 4) {
                current = next;
                continue;
            }
            // If there is no place to clean
            else {
                // Move backward
                next = current.moveDirection(oppositeDirection(curDir));

                // If backward is cleaned
                if (arr[next.x][next.y] == -1) {
                    current = next;
                }
                // If backward is wall
                else {
                    isClean = false;
                }
            }
        }

        bw.write(cleanCnt + "");

        br.close();
        bw.flush();
        bw.close();
    }

}
