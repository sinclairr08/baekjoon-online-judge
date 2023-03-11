import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _15738 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int numArr = Integer.parseInt(st.nextToken());
        int place = Integer.parseInt(st.nextToken());
        int numOp = Integer.parseInt(st.nextToken());

        br.readLine();
        int curOp;

        for (int i = 0; i < numOp; i++) {
            curOp = Integer.parseInt(br.readLine());

            if (curOp > 0) {
                if (place > curOp) {
                    continue;
                }

                place = (curOp + 1) - place;
            }

            else {
                curOp = -curOp;

                if (curOp + place <= numArr) {
                    continue;
                }

                place = (2 * numArr - curOp + 1) - place;
            }
        }

        bw.write(place + "");

        br.close();
        bw.flush();
        bw.close();
    }

}
