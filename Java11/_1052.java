import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class _1052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nums = br.readLine().split(" ");

        int N = Integer.parseInt(nums[0]);
        int K = Integer.parseInt(nums[1]);

        ArrayList<Integer> bin = new ArrayList<>();

        while (N > 0) {
            bin.add(N % 2);
            N /= 2;
        }

        int idx = 0;
        int buy = 0;

        while (bin.stream().mapToInt(Integer::intValue).sum() > K) {
            if (bin.get(idx) == 1) {
                buy += (int) Math.pow(2, idx);

                while(idx < bin.size()) {
                    if (bin.get(idx) == 1){
                        bin.set(idx, 0);
                        idx += 1;
                    }
                    else {
                        bin.set(idx, 1);
                        break;
                    }
                }

                if (idx == bin.size()) break;
            }
            else {
                idx += 1;
            }

        }

        bw.write(buy + "\n");
       
        br.close();
        bw.flush();
        bw.close();
    }
    
}
