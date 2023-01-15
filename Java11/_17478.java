import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _17478 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));   
    static int N;

    final static String InitiateSori = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n";
    final static String StartSori = "\"재귀함수가 뭔가요?\"\n";
    final static String[] MiddleSoris = {"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n", "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n", "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n"};
    final static String Answer = "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n";
    final static String EndSori = "라고 답변하였지.\n";
    final static String Pad = "____";

    public static void dfs(int depth) throws IOException {
        String CurPad = Pad.repeat(depth);

        bw.write(CurPad + StartSori);
        if (depth == N) {
            bw.write(CurPad + Answer);
            bw.write(CurPad + EndSori);
            return;
        }

        for (String ms: MiddleSoris){
            bw.write(CurPad + ms);
        }
        dfs(depth + 1);
        bw.write(CurPad + EndSori);

        return;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        bw.write(InitiateSori);

        dfs(0);

        br.close();
        bw.flush();
        bw.close();
    }
    
}
