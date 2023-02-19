import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _22864 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nums = br.readLine().split(" ");

        int plusP = Integer.parseInt(nums[0]);
        int numTask = Integer.parseInt(nums[1]);
        int minusP = Integer.parseInt(nums[2]);
        int maxP = Integer.parseInt(nums[3]);

        int curP = 0;
        int curTask = 0;

        for (int i = 1; i <= 24; i++) {
            if (curP + plusP <= maxP) {
                curTask += numTask;
                curP += plusP;
            } else {
                curP = curP < minusP ? 0 : curP - minusP;
            }
        }

        bw.write(curTask + "");

        br.close();
        bw.flush();
        bw.close();
    }

}
