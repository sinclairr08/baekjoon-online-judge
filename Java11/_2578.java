import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _2578 {
    public static int check_bingo(int[][] bingo, int x, int y) {
        int sum_x = 0, sum_y = 0;
        int sum_diag_1 = 0;
        int sum_diag_2 = 0;

        for (int k = 0; k < 5; k++) {
            sum_x += bingo[x][k];
            sum_y += bingo[k][y];

            if (x == y) {
                sum_diag_1 += bingo[k][k];
            }

            if (x + y == 4) {
                sum_diag_2 += bingo[k][4 - k];
            }
        }

        return (sum_x / 5) + (sum_y / 5) + (sum_diag_1 / 5) + (sum_diag_2 / 5);

    }
    public static void main(String[] args) throws IOException {
        class Pair {
            public int x;
            public int y;
        
            Pair(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Pair[] board = new Pair[26];
        int[] calls = new int[25];
        int[][] bingos = new int[5][5];

        for (int i = 0; i < 10; i++) {
            String[] nums = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(nums[j]);
                if (i < 5) {
                    board[num] = new Pair(i, j);
                    bingos[i][j] = 0;
                }
                else {
                    calls[(i - 5) * 5 + j] = num;
                }
            }
        }

        int bingo_lines = 0;

        for (int cnt = 0; cnt < 25; cnt++){
            Pair place = board[calls[cnt]];
            bingos[place.x][place.y] = 1;

            bingo_lines += check_bingo(bingos, place.x, place.y);
            if (bingo_lines >= 3) {
                bw.write((cnt + 1) + "");
                break;
            }

        }
        
        br.close();
        bw.flush();
        bw.close();
    }
    
}
