import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] S = new int[21];
        
        String[] nums;
        String command;
        int val = 0;

        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < N; i++){
            nums = br.readLine().split(" ");
            command = nums[0];
            
            if (nums.length > 1) {
                val = Integer.parseInt(nums[1]);
            }

            if(command.equals("add")) {
                S[val] = 1;
                
            }
            else if (command.equals("remove")) {
                S[val] = 0;
            }
            else if (command.equals("check")) {
               sb.append(S[val]);
               sb.append("\n");
            }
            else if (command.equals("toggle")) {
                S[val] = 1 - S[val];
            }
            else if (command.equals("all")) {
                for (int j = 1; j <= 20; j++) {
                    S[j] = 1;
                }
            }
            else {
                for (int j = 1; j <= 20; j++) {
                    S[j] = 0;
                }
            }
        }

        bw.write(sb.toString());
        
        br.close();
        bw.flush();
        bw.close();
    }
    
}
