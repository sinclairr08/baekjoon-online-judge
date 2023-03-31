import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _16967 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int mx = Integer.parseInt(st.nextToken());
        int my = Integer.parseInt(st.nextToken());
        int dx = Integer.parseInt(st.nextToken());
        int dy = Integer.parseInt(st.nextToken());

        int[][] arr = new int[mx + dx][my + dy];

        for (int i = 0; i < mx + dx; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < my + dy; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = dx; i < mx + dx; i++) {
            for (int j = dy; j < my + dy; j++) {
                arr[i][j] -= arr[i - dx][j - dy];
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < mx; i++) {
            for (int j = 0; j < my; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

}
