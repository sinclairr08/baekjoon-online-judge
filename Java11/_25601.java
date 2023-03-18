import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _25601 {
    public static void main(String[] args) throws IOException {
        class TreeInfo {
            TreeInfo parent;

            TreeInfo() {
                this.parent = null;
            }

            TreeInfo(TreeInfo parent) {
                this.parent = parent;
            }
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        String child, parent;

        Map<String, TreeInfo> hash = new HashMap<>();
        TreeInfo curParent;

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            child = st.nextToken();
            parent = st.nextToken();

            if (hash.getOrDefault(parent, null) != null) {
                curParent = hash.get(parent);
            } else {
                hash.put(parent, new TreeInfo());
                curParent = hash.get(parent);
            }

            if (hash.getOrDefault(child, null) != null) {
                hash.get(child).parent = curParent;
            } else {
                hash.put(child, new TreeInfo(curParent));
            }
        }

        st = new StringTokenizer(br.readLine());

        String c1 = st.nextToken();
        String c2 = st.nextToken();

        int typeable = 0;

        TreeInfo s1 = hash.get(c1);
        TreeInfo s2 = hash.get(c2);

        while (typeable != 1 && s1 != null) {
            if (s1.equals(s2)) {
                typeable = 1;
            }
            s1 = s1.parent;
        }

        s1 = hash.get(c1);

        while (typeable != 1 && s2 != null) {
            if (s2.equals(s1)) {
                typeable = 1;
            }
            s2 = s2.parent;
        }

        bw.write(typeable + "");

        br.close();
        bw.flush();
        bw.close();
    }

}
