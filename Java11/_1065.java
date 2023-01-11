import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        boolean[] isHan = new boolean[1001];
        int [] accum = new int[1001];

        for (int i = 1; i <= 1000; i++) {
            if (i < 100){
                isHan[i] = true;
                continue;
            }
            if (i == 1000) {
                isHan[i] = false;
                break;
            }

            int a = i / 100;
            int b = (i / 10) % 10;
            int c = i % 10;

            isHan[i] = a - b == b - c ? true : false;
            
        }

        accum[0] = 0;

        for (int i = 1; i <= 1000; i++) {
            accum[i] = accum[i - 1] + (isHan[i] ? 1 : 0);
        }

        bw.write(accum[N] + "");

        br.close();
        bw.flush();
        bw.close();
    }
    
}
