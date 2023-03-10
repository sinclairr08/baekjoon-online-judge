import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _17609 {
    public static boolean subPalindromeCheck(String s, int sIdx, int eIdx) {
        while (sIdx < eIdx) {
            if (s.charAt(sIdx) != s.charAt(eIdx)) {
                return false;
            }
            sIdx++;
            eIdx--;
        }

        return true;
    }

    public static String isPalindrome(String s) {
        int startIdx = 0;
        int endIdx = s.length() - 1;

        while (startIdx < endIdx) {
            if (s.charAt(startIdx) == s.charAt(endIdx)) {
                startIdx += 1;
                endIdx -= 1;
                continue;
            }

            if (subPalindromeCheck(s, startIdx + 1, endIdx) || subPalindromeCheck(s, startIdx, endIdx - 1)) {
                return "1";
            } else {
                return "2";
            }

        }

        return "0";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            bw.write(isPalindrome(br.readLine()));
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();
    }

}
