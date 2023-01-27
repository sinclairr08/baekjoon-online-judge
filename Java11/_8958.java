import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            int sum = 0;
            int score = 0;
            
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == 'O') {
                    score += 1;
                    sum += score;
                }
                else {
                    score = 0;
                }
            }

            bw.write(sum + "\n");
        }
         
        br.close();
        bw.flush();
        bw.close();
    }
    
}
