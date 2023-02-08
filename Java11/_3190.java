import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class _3190 {
    public static void main(String[] args) throws IOException {
        class Pair {
            int x;
            int y;
        
            Pair(int x, int y) {
                this.x = x;
                this.y = y;
            }
        
            public void turnDirectionRight() {
                if (this.x == 0) {
                    this.x = this.y;
                    this.y = 0;
                }
                else {
                    this.y = -this.x;
                    this.x = 0;
                }
            }
        
            public void turnDirectionLeft() {
                if (this.x == 0) {
                    this.x = -this.y;
                    this.y = 0;
                }
                else {
                    this.y = this.x;
                    this.x = 0;
                }
            }
        
            public Pair add(Pair p) {
                return new Pair(this.x + p.x, this.y + p.y);
            }
        
            public boolean isInValid (int size) {
                if (this.x > size || this.x <= 0 || this.y > size || this.y <= 0) {
                    return true;
                }
                return false;
            }
        
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());
        int[][] boardState = new int[size + 1][size + 1];   // 1 : snake, -1: apple

        int numApple = Integer.parseInt(br.readLine());
        String[] nums;

        for (int i = 0; i < numApple; i++) {
            nums = br.readLine().split(" ");

            int row = Integer.parseInt(nums[0]);
            int col = Integer.parseInt(nums[1]);

            boardState[row][col] = -1;
        }

        int numCommand = Integer.parseInt(br.readLine());
        int[] commands = new int[10001];    // 1 : move right, -1: move left

        for (int i = 0; i < numCommand; i++) {
            nums = br.readLine().split(" ");

            int commandIdx = Integer.parseInt(nums[0]);
            char command = nums[1].charAt(0);

            if (command == 'D') {
                commands[commandIdx] = 1;
            }
            else {
                commands[commandIdx] = -1;
            }
        }

        Deque<Pair> queue = new ArrayDeque<>();
        queue.addFirst(new Pair(1, 1));

        int idx = 0;
        
        Pair Direction = new Pair(0, 1);
        Pair Head, Next, Tail;

        while(queue.size() > 0) {
            idx += 1;
            Head = queue.peekFirst();
            Next = Head.add(Direction);

            // If head meets wall
            if (Next.isInValid(size))
                break;

            queue.addFirst(Next);

            // If head meets body
            if (boardState[Next.x][Next.y] == 1) { 
                break;
            }
            // If head does not meet apple
            else if (boardState[Next.x][Next.y] != -1) {
                Tail = queue.pollLast();
                boardState[Tail.x][Tail.y] = 0;
            }

            boardState[Next.x][Next.y] = 1;

            if (commands[idx] == 1) {
                Direction.turnDirectionRight();
            }
            else if (commands[idx] == -1) {
                Direction.turnDirectionLeft();
            }

            /**
            bw.write(idx + "초 후의 상황\n");
            for (Pair p : queue) {
                bw.write("x : " + p.x + ", y : " + p.y + "\n");
            }
             */
        }
        
        bw.write(idx + "");
        
        br.close();
        bw.flush();
        bw.close();
    }
    
}
