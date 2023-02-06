import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class DoubleLinkedList {
    DoubleLinkedList prev;
    DoubleLinkedList next;
    int num;

    DoubleLinkedList(int N) {
        this.num = N;
    }

    void delete() {
        this.prev.next = this.next;
        this.next.prev = this.prev;
    }
}

public class _20301 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nums = br.readLine().split(" ");

        int N = Integer.parseInt(nums[0]);
        int nextCnt = Integer.parseInt(nums[1]);
        int turnCnt = Integer.parseInt(nums[2]);

        DoubleLinkedList[] store = new DoubleLinkedList[N];

        for (int i = 0; i < N; i++) {
            store[i] = new DoubleLinkedList(i + 1);
        }

        for (int i = 0; i < N; i++) {
            if (i > 0) {
                store[i].prev = store[i - 1];
            }
            else {
                store[i].prev = store[N - 1];
            }

            if (i < N - 1) {
                store[i].next = store[i + 1];
            }
            else {
                store[i].next = store[0];
            }
        }

        StringBuilder sb = new StringBuilder();
        boolean isRigthDirection = false;
        DoubleLinkedList start = store[N - 1];
        int curCnt;

        for (int i = 0; i < N; i++) {
            if (i % turnCnt == 0) {
                isRigthDirection = !isRigthDirection;
            }

            curCnt = 0;
            while(curCnt++ < nextCnt) {
                if (isRigthDirection) {
                    start = start.next;
                }
                else {
                    start = start.prev;
                }
            }

            sb.append(start.num).append("\n");
            start.delete();
            
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
    
}
