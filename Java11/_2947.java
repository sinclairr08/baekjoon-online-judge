import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _2947 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static boolean isValid(int[] arr) {
        for (int i = 1; i < 5; i++) {
            if (arr[i] != i)
                return false;
        }

        return true;
    }

    public static void printArr(int[] arr) throws IOException {
        for (int i = 1; i <= 5; i++) {
            bw.write(arr[i] + " ");
        }
        bw.newLine();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nums = br.readLine().split(" ");
        int[] arr = new int[6];

        for (int i = 1; i <= 5; i++) {
            arr[i] = Integer.parseInt(nums[i - 1]);
        }

        int temp;

        while (!isValid(arr)) {
            for (int i = 1; i < 5; i++) {
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;

                    printArr(arr);
                }
            }

        }

        br.close();
        bw.flush();
        bw.close();
    }

}
