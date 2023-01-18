import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        br.readLine();
        String nums = br.readLine();
        int res = 0;

        for (String c: nums.split("")){
            res += Integer.parseInt(c);
        }

        bw.write(res + "");
        
        br.close();
        bw.flush();
        bw.close();
    }
    
}
