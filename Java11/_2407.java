import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class _2407 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nums = br.readLine().split(" ");

        int n = Integer.parseInt(nums[0]);
        int m = Integer.parseInt(nums[1]);

        if (m > n /2) {
            m = n - m;
        }

        BigInteger b = new BigInteger("1");

        for (int i = 0; i < m; i++) {
            b = b.multiply(BigInteger.valueOf(n - i));
            b = b.divide(BigInteger.valueOf(i + 1));
        }

        bw.write(b.toString());
 
        br.close();
        bw.flush();
        bw.close();
    }
    
}
