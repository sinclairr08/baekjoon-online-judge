import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1547 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int iterN = Integer.parseInt(br.readLine());

        // cups[i] => i번째 컵이 위치한 곳
        int[] cups = { 0, 1, 2, 3 };

        for (int i = 0; i < iterN; i++) {
            String[] nums = br.readLine().split(" ");

            int x = Integer.parseInt(nums[0]);
            int y = Integer.parseInt(nums[1]);

            int temp = cups[x];
            cups[x] = cups[y];
            cups[y] = temp;

        }

        for (int i = 1; i <= 3; i++) {
            if (cups[i] == 1) {
                bw.write(i + "");
                break;
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }

}
