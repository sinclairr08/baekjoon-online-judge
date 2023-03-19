import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _5212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nums = br.readLine().split(" ");

        int row = Integer.parseInt(nums[0]);
        int col = Integer.parseInt(nums[1]);

        int[][] grid = new int[row][col];

        for (int r = 0; r < row; r++) {
            String s = br.readLine();

            for (int c = 0; c < col; c++) {
                grid[r][c] = s.charAt(c) == '.' ? 0 : 1;
            }
        }

        int zerocount;

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (grid[r][c] == 0)
                    continue;

                zerocount = 0;

                if (r - 1 < 0 || grid[r - 1][c] == 0)
                    zerocount += 1;
                if (c - 1 < 0 || grid[r][c - 1] == 0)
                    zerocount += 1;
                if (r + 1 >= row || grid[r + 1][c] == 0)
                    zerocount += 1;
                if (c + 1 >= col || grid[r][c + 1] == 0)
                    zerocount += 1;

                if (zerocount >= 3) {
                    grid[r][c] = -1;
                }

            }
        }

        int col_min = col;
        int col_max = 0;
        int row_min = row;
        int row_max = 0;

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (grid[r][c] == 1) {
                    col_min = c < col_min ? c : col_min;
                    col_max = c > col_max ? c : col_max;
                    row_min = r < row_min ? r : row_min;
                    row_max = r > row_max ? r : row_max;
                }
            }
        }

        for (int r = row_min; r <= row_max; r++) {
            for (int c = col_min; c <= col_max; c++) {
                bw.write(grid[r][c] == 1 ? "X" : ".");
            }
            bw.write("\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

}
