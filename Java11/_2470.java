import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2470 {
    public static int abs(int N) {
        return N >= 0 ? N : -N;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int leftIdx = 0;
        int rightIdx = arr.length - 1;
        int min = abs(arr[leftIdx] + arr[rightIdx]);
        int recordedLeft = leftIdx;
        int recordedRight = rightIdx;

        int current;

        while (leftIdx < rightIdx) {
            current = arr[leftIdx] + arr[rightIdx];

            if (abs(current) < min) {
                min = abs(current);
                recordedLeft = leftIdx;
                recordedRight = rightIdx;
            }

            if (current > 0) {
                rightIdx--;
            } else if (current < 0) {
                leftIdx++;
            } else {
                break;
            }
        }

        bw.write(arr[recordedLeft] + " " + arr[recordedRight]);

        br.close();
        bw.flush();
        bw.close();
    }

}
