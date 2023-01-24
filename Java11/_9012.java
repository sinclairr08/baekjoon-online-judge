import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _9012 {
    public static boolean isValid(String s) {
        int cnt = 0;       
        
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == '(') {
                cnt++;
            }
            else if (cnt > 0){
                cnt--;
            }
            else {
                return false;
            }
        }

        return cnt == 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        boolean isVPS;

        for (int i = 0; i < N; i++) {
            isVPS = isValid(br.readLine());

            bw.write(isVPS ? "YES\n" : "NO\n" );
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
    
}
