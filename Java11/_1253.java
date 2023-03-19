import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _1253 {
    public static void main(String[] args) throws IOException {
        class Composed {
            int x;
            int y;

            Composed(int x, int y) {
                this.x = x;
                this.y = y;
            }

            public void compare(int ox, int oy) {
                if (this.x != -1 && this.x != ox && this.x != oy) {
                    this.x = -1;
                }
                if (this.y != -1 && this.y != ox && this.y != oy) {
                    this.y = -1;
                }
            }

            public boolean contains(int v) {
                if (this.x == v || this.y == v) {
                    return true;
                } else {
                    return false;
                }
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Composed> record = new HashMap<>();

        int current, good;

        for (int i = 0; i < N; i++) {
            current = Integer.parseInt(st.nextToken());
            arr[i] = current;

            for (int j = 0; j < i; j++) {
                good = current + arr[j];

                if (record.getOrDefault(good, null) == null) {
                    record.put(good, new Composed(i, j));
                } else {
                    record.get(good).compare(i, j);
                }
            }
        }

        int result = 0;

        for (int i = 0; i < N; i++) {
            Composed c;
            if ((c = record.getOrDefault(arr[i], null)) != null) {
                if (!c.contains(i)) {
                    result += 1;
                }
            }
        }

        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }

}
