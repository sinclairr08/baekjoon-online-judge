import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class _1759 {
    public static StringBuilder sb = new StringBuilder();
    public static char[] candidates;
    public static int passwordLen;
    public static int passwordKind;
    final static List<Character> vowel = List.of('a', 'e', 'i', 'o', 'u');

    public static boolean isValid(List<Character> arr) {
        int vowelCnt = 0;
        int consonCnt = 0;

        for (char a: arr) {
            if (vowel.contains(a)) {
                vowelCnt += 1;
            }
            else {
                consonCnt += 1;
            }
        }

        if (vowelCnt < 1 || consonCnt < 2) {
            return false;
        }

        return true;
    }

    public static void dfs(int depth, int idx, List<Character> arr) {
        if (depth == passwordLen) {
            if (!isValid(arr))
                return;

            for (char a: arr) {
                sb.append(a);
            }
            
            sb.append("\n");
            return;
        }

        for (int i = idx; i < passwordKind; i++) {
            arr.add(candidates[i]);
            dfs(depth + 1, i + 1, arr);
            arr.remove(arr.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        passwordLen = Integer.parseInt(st.nextToken());
        passwordKind = Integer.parseInt(st.nextToken());
        candidates = new char[passwordKind];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < passwordKind; i++) {
            candidates[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(candidates);

        dfs(0, 0, new ArrayList<Character>());

        bw.write(sb.toString());
        
        br.close();
        bw.flush();
        bw.close();
    }
    
}
