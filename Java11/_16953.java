import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

class Info {
    int cnt;
    long val;

    Info(int cnt, long val) {
        this.cnt = cnt;
        this.val = val;
    }
}

public class _16953 {
    public static int bfs(Deque<Info> que, long B) {
        Info curInfo;
        long curVal;
        int curCnt;
        while(que.size() > 0) {
            curInfo = que.pollFirst();

            curVal = curInfo.val;
            curCnt = curInfo.cnt;
          
            if (curVal * 2 == B) {
                return curCnt + 1;
            }
            
            if (curVal * 2 < B) {
                que.add(new Info(curCnt + 1, curVal * 2));
            }

            if ((curVal * 10) + 1 == B) {
                return curCnt + 1;
            }
            
            if ((curVal * 10) + 1 < B){
                que.add(new Info(curCnt + 1, (curVal * 10) + 1));
            }

        }

        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nums = br.readLine().split(" ");

        long A = Long.parseLong(nums[0]);
        long B = Long.parseLong(nums[1]);

        Deque<Info> que = new ArrayDeque<Info>();
        que.add(new Info(1, A));

        bw.write(Integer.toString(bfs(que, B)));
        
        br.close();
        bw.flush();
        bw.close();
    }
    
}
