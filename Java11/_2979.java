import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _2979 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nums = br.readLine().split(" ");
        int[] pays = new int[4];

        for (int i = 1; i <= 3; i++){
            pays[i] =  Integer.parseInt(nums[i - 1]) * i;
        }

        int[] cars = new int[101];

        for(int i = 0; i < 3; i++){
            String[] s = br.readLine().split(" ");

            int startT = Integer.parseInt(s[0]);
            int endT = Integer.parseInt(s[1]);

            cars[startT] += 1;
            cars[endT] -= 1;
        }

        int result = 0;
        for (int i = 1; i < 100; i++) {
            cars[i] += cars[i - 1];
            result += pays[cars[i]];
        }

        bw.write(result + "");
        
        br.close();
        bw.flush();
        bw.close();
    }
    
}
