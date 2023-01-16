import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class _1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < N; i++){
            String[] nums = br.readLine().split(" ");
            
            int queueLength = Integer.parseInt(nums[0]);
            int queuePlace = Integer.parseInt(nums[1]);

            Queue<Integer> printer = new LinkedList<Integer>();
            String[] values = br.readLine().split(" ");

            for (int j = 0; j < queueLength; j++){
                printer.add(Integer.parseInt(values[j]));
            }

            int top, max_val;
            int cnt = 1;
            
            while(printer.size() > 0) {
                top = printer.remove();
                max_val = top;
                
                for (int item: printer) {
                    max_val = item > max_val ? item : max_val;
                }

                if (max_val != top) {
                    while(max_val != top) {
                        printer.add(top);
                        queuePlace = queuePlace == 0 ? printer.size() - 1 : queuePlace - 1;
                        top = printer.remove();
                    }
                }
   
                if (queuePlace == 0) {
                    bw.write(cnt + "\n");
                    break;
                }
                else {
                    cnt += 1;
                    queuePlace -= 1;
                }
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
    
}
