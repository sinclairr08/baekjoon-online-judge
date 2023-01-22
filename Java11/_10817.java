import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _10817 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nums = br.readLine().split(" ");

        int a = Integer.parseInt(nums[0]);
        int b = Integer.parseInt(nums[1]);
        int c = Integer.parseInt(nums[2]);

        int max = a;
        int min = a;

        if (b > max) max = b;
        if (b < min) min = b;

        if (c > max) max = c;
        if (c < min) min = c;

        bw.write((a + b + c - max - min) + "");
        
        br.close();
        bw.flush();
        bw.close();
    }
    
}

