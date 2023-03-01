import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class _13335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int numTrucks = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());
        int maxLoad = Integer.parseInt(st.nextToken());

        int[] trucks = new int[numTrucks];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numTrucks; i++) {
            trucks[i] = Integer.parseInt(st.nextToken());
        }

        int time = 0;
        int idx = 0;
        int outTrucks = 0;
        int curLoad = 0;
        int curWeight;

        Deque<Integer> bridge = new ArrayDeque<Integer>(length);

        for (int i = 0; i < length; i++) {
            bridge.addLast(0);
        }

        while (outTrucks < numTrucks) {
            curWeight = bridge.pollFirst();
            time += 1;

            if (curWeight > 0) {
                outTrucks += 1;
                curLoad -= curWeight;
            }

            if (idx == numTrucks)
                continue;

            if (curLoad + trucks[idx] <= maxLoad) {
                bridge.addLast(trucks[idx]);
                curLoad += trucks[idx];
                idx += 1;
            } else {
                bridge.addLast(0);
            }

        }

        bw.write(time + "");

        br.close();
        bw.flush();
        bw.close();
    }

}
