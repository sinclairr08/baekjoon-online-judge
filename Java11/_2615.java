import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _2615 {
    public static int[][] arr = new int[19][19];
    public static int[][] dirs = { { 0, 1 }, { 1, 0 }, { 1, 1 }, { -1, 1 } };

    public static boolean isInsideBoundary(int x, int y) {
        if (x < 0 || y < 0 || x > 18 || y > 18) {
            return false;
        }
        return true;
    }

    public static boolean checkRow(int x, int y, int[] d) {
        int curStoneColor = arr[x][y];

        int x_ = x - d[0];
        int y_ = y - d[1];

        // Failed on previous stone
        if (isInsideBoundary(x_, y_) && arr[x_][y_] == curStoneColor) {
            return false;
        }

        for (int step = 1; step < 5; step++) {
            x_ = x + d[0] * step;
            y_ = y + d[1] * step;

            if (!isInsideBoundary(x_, y_) || arr[x_][y_] != curStoneColor) {
                return false;
            }
        }
        // If length of row > 5

        x_ = x + d[0] * 5;
        y_ = y + d[1] * 5;
        if (isInsideBoundary(x_, y_) && arr[x_][y_] == curStoneColor) {
            return false;
        }
        return true;
    }

    public static boolean check(int x, int y) {
        for (int[] d : dirs) {
            if (checkRow(x, y, d)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        arr = new int[19][19];

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                arr[i][j] = System.in.read() & 15;
                System.in.read();
            }
        }

        boolean isFinished = false;
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < 19; j++) {
            for (int i = 0; i < 19; i++) {
                if (arr[i][j] == 0)
                    continue;

                if (check(i, j)) {
                    isFinished = true;
                    sb.append(arr[i][j]).append("\n").append(i + 1).append(" ").append(j + 1);
                    bw.write(sb.toString());
                    break;
                }

            }

            if (isFinished) {
                break;
            }
        }

        if (!isFinished) {
            bw.write("0");
        }

        br.close();
        bw.flush();
        bw.close();
    }

}
