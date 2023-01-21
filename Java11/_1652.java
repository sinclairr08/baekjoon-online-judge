import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        boolean[][] layable = new boolean[N][N];
        String s;

        for (int i = 0; i < N; i++) {
            s = br.readLine();
            for (int j = 0; j < N; j++) {
                layable[i][j] = (s.charAt(j) == '.');
            }
        }

        int hor = 0, ver = 0;
        int cur_hor_cnt, cur_ver_cnt;

        for (int i = 0; i < N; i++) {
            cur_hor_cnt = 0;
            cur_ver_cnt = 0;
            for (int j = 0; j < N; j++) {
                if(layable[i][j]) {
                    cur_hor_cnt += 1;
                    if (cur_hor_cnt == 2)
                        hor += 1;
                }
                else {
                    cur_hor_cnt = 0;
                }           
                
                if (layable[j][i]) {
                    cur_ver_cnt += 1;
                    if (cur_ver_cnt == 2) {
                        ver += 1;
                    }
                }
                else {
                    cur_ver_cnt = 0;
                }
            }
        }
        
        bw.write(hor + " " + ver);
        
        br.close();
        bw.flush();
        bw.close();
    }
    
}
