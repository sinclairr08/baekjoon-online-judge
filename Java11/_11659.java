import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N + 1];

        arr[0] = 0;

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken()) + arr[i - 1];
        }

        int startIdx, endIdx;
        
        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            startIdx = Integer.parseInt(st.nextToken());
            endIdx = Integer.parseInt(st.nextToken());

            bw.write((arr[endIdx] - arr[startIdx - 1]) + "\n");
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
    
}
