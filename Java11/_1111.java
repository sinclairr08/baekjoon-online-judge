import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1111 {
    public static String checkValid(int[] arr, int N) {
        if (N < 2) {
            return "A";
        }
        if (N == 2) {
            if (arr[1] == arr[0]) {
                return arr[0] + "";
            } else {
                return "A";
            }
        }

        int A, B;

        if (arr[1] == arr[0]) {
            A = 0;
            B = arr[0];
        } else if (((arr[2] - arr[1]) % (arr[1] - arr[0])) != 0) {
            return "B";
        } else {
            A = ((arr[2] - arr[1]) / (arr[1] - arr[0]));
            B = arr[1] - (arr[0] * A);
        }

        for (int i = 0; i < N - 1; i++) {
            if (arr[i + 1] != ((arr[i] * A) + B)) {
                return "B";
            }
        }

        return ((arr[N - 1] * A) + B) + "";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(checkValid(arr, N));

        br.close();
        bw.flush();
        bw.close();
    }

}
