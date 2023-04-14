import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _7682 {
    public static boolean checkLine(boolean a1, boolean a2, boolean a3) {
        return true & a1 & a2 & a3;
    }

    public static boolean isLine(boolean[][] board) {
        if (checkLine(board[0][0], board[1][1], board[2][2])) {
            return true;
        }

        if (checkLine(board[0][2], board[1][1], board[2][0])) {
            return true;
        }
        for (int i = 0; i < 3; i++) {
            if (checkLine(board[i][0], board[i][1], board[i][2])) {
                return true;
            }
            if (checkLine(board[0][i], board[1][i], board[2][i])) {
                return true;
            }
        }

        return false;
    }

    public static String check(boolean[][] xBoard, boolean[][] oBoard, int xCount, int oCount) {
        String val = "valid";
        String inval = "invalid";

        if ((xCount + oCount) % 2 == 0) {
            if (xCount != oCount) {
                return inval;
            }
        }

        else {
            if (xCount != oCount + 1) {
                return inval;
            }
        }

        boolean xLine = isLine(xBoard);
        boolean oLine = isLine(oBoard);

        if (xLine && oLine) {
            return inval;
        }

        if (xLine && xCount != oCount + 1) {
            return inval;
        }

        if (oLine && xCount != oCount) {
            return inval;
        }

        if (!xLine && !oLine) {
            if (xCount + oCount == 9) {
                return val;
            } else {
                return inval;
            }
        }

        return val;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s;
        while (!(s = br.readLine()).equals("end")) {
            boolean[][] xBoard = new boolean[3][3];
            boolean[][] oBoard = new boolean[3][3];

            int xCount = 0;
            int oCount = 0;

            for (int i = 0; i < 9; i++) {
                if (s.charAt(i) == 'X') {
                    xCount++;
                    xBoard[i / 3][i % 3] = true;
                } else if (s.charAt(i) == 'O') {
                    oCount++;
                    oBoard[i / 3][i % 3] = true;
                }
            }
            bw.write(check(xBoard, oBoard, xCount, oCount));
            bw.newLine();

        }

        br.close();
        bw.flush();
        bw.close();
    }

}
