import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class pair {
    public int x;
    public int y;

    public pair(String x, String y) {
        this.x = Integer.parseInt(x);
        this.y = Integer.parseInt(y);
    }

    public int get_dist(pair other) {
        int dx = other.x - this.x;
        int dy = other.y - this.y;
        return (dx * dx) + (dy * dy);
    }
}

public class _1002 {
    public static int get_point(String[] nums){
        pair p1 = new pair(nums[0], nums[1]);
        pair p2 = new pair(nums[3], nums[4]);

        int d = p1.get_dist(p2);

        int r1 = Integer.parseInt(nums[2]);
        int r2 = Integer.parseInt(nums[5]);

        int sum_r = (r1 + r2) * (r1 + r2);
        int diff_r = (r1 - r2) * (r1 - r2);

        if (d > sum_r) return 0;
        if (d == sum_r) return 1;
        if (d > diff_r) return 2;
        if (d < diff_r) return 0;
        if (d != 0) return 1;
        else return -1;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            String[] nums = br.readLine().split(" ");
            bw.write(get_point(nums) + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
    
}
