import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1074 {
    public static int exp_2(int n) {
        int res = 1;
        while (n-- > 0) {
            res *= 2;
        }
        return res;
    }

    public static int dfs(int depth, int r, int c) {
        if (depth == 0) {
            return 0;
        }

        int pivot = exp_2(depth) / 2;
        int res = 0;

        if (r >= pivot) {
            res += pivot * pivot * 2;
            r -= pivot;
        }

        if (c >= pivot) {
            res += pivot * pivot;
            c -= pivot;
        }

        return dfs(depth - 1, r, c) + res;
        
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nums = br.readLine().split(" ");

        int N = Integer.parseInt(nums[0]);
        int row = Integer.parseInt(nums[1]);
        int col = Integer.parseInt(nums[2]);

        bw.write(dfs(N, row, col) + "");
        
        br.close();
        bw.flush();
        bw.close();
    }
    
}

