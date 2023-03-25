import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _1706 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nums = br.readLine().split(" ");

        int row = Integer.parseInt(nums[0]);
        int col = Integer.parseInt(nums[1]);

        String[] puzzle = new String[row];
        List<String> words = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            puzzle[i] = br.readLine();
        }

        int wordSize;
        char curChar;
        StringBuilder sb;

        for (int i = 0; i < row; i++) {
            wordSize = 0;
            sb = new StringBuilder();

            for (int j = 0; j < col; j++) {
                curChar = puzzle[i].charAt(j);
                if (curChar == '#') {
                    if (wordSize > 1) {
                        words.add(sb.toString());
                    }

                    wordSize = 0;
                    sb = new StringBuilder();
                }

                else {
                    wordSize++;
                    sb.append(curChar);
                }
            }
            if (wordSize > 1) {
                words.add(sb.toString());
            }
        }

        for (int j = 0; j < col; j++) {
            wordSize = 0;
            sb = new StringBuilder();

            for (int i = 0; i < row; i++) {
                curChar = puzzle[i].charAt(j);
                if (curChar == '#') {
                    if (wordSize > 1) {
                        words.add(sb.toString());
                    }

                    wordSize = 0;
                    sb = new StringBuilder();
                }

                else {
                    wordSize++;
                    sb.append(curChar);
                }
            }
            if (wordSize > 1) {
                words.add(sb.toString());
            }
        }

        Collections.sort(words);
        bw.write(words.get(0));

        br.close();
        bw.flush();
        bw.close();
    }

}
