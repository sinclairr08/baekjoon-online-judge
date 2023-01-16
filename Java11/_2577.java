import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long A = Long.parseLong(br.readLine());
        long B = Long.parseLong(br.readLine());
        long C = Long.parseLong(br.readLine());

        long result = A * B * C;
        int[] digits = new int[10];

        while (result != 0) {
            digits[(int)(result % 10)] += 1;
            result /= 10;
        }

        for (int i = 0; i < 10; i++){
            bw.write(digits[i] + "\n");
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
    
}
