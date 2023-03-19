import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class _16965 {
    public static int bfs(List<Integer>[] movable, int start, int end, int N) {
        boolean visited[] = new boolean[N];
        Deque<Integer> queue = new ArrayDeque<>();

        visited[start] = true;
        queue.add(start);

        while (queue.size() > 0) {
            int current = queue.pollFirst();
            if (current == end) {
                return 1;
            }

            for (int e : movable[current]) {
                if (!visited[e]) {
                    queue.add(e);
                    visited[e] = true;
                }
            }

        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        class Section {
            int start;
            int end;

            Section(int start, int end) {
                this.start = start;
                this.end = end;
            }

            public boolean isMovable(Section dest) {
                if (dest.start < this.start && this.start < dest.end) {
                    return true;
                }
                if (dest.start < this.end && this.end < dest.end) {
                    return true;
                }
                return false;
            }

        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        Section[] sections = new Section[N + 1];
        Section curSection;
        int sectionIdx = 1;

        @SuppressWarnings("unchecked")
        List<Integer>[] movable = new ArrayList[N + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int qNum = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if (qNum == 1) {
                sections[sectionIdx] = new Section(start, end);
                movable[sectionIdx] = new ArrayList<>();
                curSection = sections[sectionIdx];

                for (int j = 1; j < sectionIdx; j++) {
                    if (curSection.isMovable(sections[j])) {
                        movable[sectionIdx].add(j);
                    }
                    if (sections[j].isMovable(curSection)) {
                        movable[j].add(sectionIdx);
                    }
                }
                sectionIdx++;
            }

            else {
                sb.append(bfs(movable, start, end, sectionIdx)).append("\n");
            }
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

}
