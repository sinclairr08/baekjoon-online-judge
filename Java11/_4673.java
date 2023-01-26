import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class _4673 {
    public static int generate(int N) {
        int sum = N;
        while (N > 0) {
            sum += N % 10;
            N /= 10;
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean[] isSelf = new boolean[10001];

        for (int i = 1; i <= 10000; i++) {
            if(!isSelf[i]){
                bw.write(i + "\n");

                int num = i;
                while (num <= 10000 && !isSelf[num]) {
                    isSelf[num] = true;
                    num = generate(num);
                }
            }
        }

        bw.flush();
        bw.close();
    }
    
}
