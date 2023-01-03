import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

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
        StringTokenizer st;

        int nums = Integer.parseInt(br.readLine());

        for(int i = 0; i < nums; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a % 10 == 0) {
                bw.write("10\n");
                continue;
            }

            bw.write(exponent(a % 10, b) + "\n");
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
    
}
