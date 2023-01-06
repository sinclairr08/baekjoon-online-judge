import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1008 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nums = br.readLine().split(" ");

        double a = Double.parseDouble(nums[0]);
        double b = Double.parseDouble(nums[1]);

        bw.write((a / b) + "");
        
        br.close();
        bw.flush();
        bw.close();
    }
    
}
