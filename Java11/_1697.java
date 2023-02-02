import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class _1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nums = br.readLine().split(" ");
        int[] min_times = new int[100001];

        int N = Integer.parseInt(nums[0]);
        int K = Integer.parseInt(nums[1]);

        if (N == K) {
            bw.write("0");
            br.close();
            bw.flush();
            bw.close();

            return;
        }

        min_times[K] = 1;
        Deque<Integer> queue = new ArrayDeque<Integer>();
        queue.add(K);

        int cur_place, cur_time;

        while(queue.size() > 0) {
            cur_place = queue.poll();
            cur_time = min_times[cur_place];           
            
            if (cur_place - 1 == N || cur_place + 1 == N || (cur_place % 2 == 0 && cur_place / 2 == N)) {
                bw.write(cur_time + "");
                break;
            }

            if (cur_place > 0 && min_times[cur_place - 1] == 0) {
                min_times[cur_place - 1] = cur_time + 1;
                queue.add(cur_place - 1);
            }

            if (cur_place < 100000 && min_times[cur_place + 1] == 0) {
                min_times[cur_place + 1] = cur_time + 1;
                queue.add(cur_place + 1);
            }
            
            if (cur_place % 2 == 0 && min_times[cur_place / 2] == 0) {
                min_times[cur_place / 2] = cur_time + 1;
                queue.add(cur_place / 2);
            }
            
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
    
}
