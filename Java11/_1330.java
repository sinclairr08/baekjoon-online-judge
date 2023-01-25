import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1330 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nums = br.readLine().split(" ");

        int A = Integer.parseInt(nums[0]);
        int B = Integer.parseInt(nums[1]);

        if (A == B) {
            bw.write("==");
        }
        else if (A < B) {
            bw.write("<");
        }
        else {
            bw.write(">");
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
    
}
