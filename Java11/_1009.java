import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1009 {
    private static int exponent(int a, int b){
        if (b == 1) return a;
       
        if (b % 2 == 1) {
            return (exponent((a * a) % 10 , b / 2) * a) % 10;
        }

        else {
            return exponent((a * a) % 10 , b / 2) % 10;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            String[] nums = br.readLine().split(" ");

            int a = Integer.parseInt(nums[0]);
            int b = Integer.parseInt(nums[1]);

            if (a % 10 == 0) {
                bw.write("10\n");
                continue;
            }

            bw.write(exponent(a % 10, b) + "\n");
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
    
}
