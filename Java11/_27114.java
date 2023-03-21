import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _27114 {
    /**
     * 정면: 0, 우측: 1, 뒤: 2, 좌측: 3
     * 좌돌 -> 0 -> 3 -> 2 -> 1
     * 우돌 -> 0 -> 1 -> 2 -> 3
     * 뒤돌 -> 0 -> 2 / 1 -> 3
     * 반대로 가야 함
     */
    public static int prevDirection(int direction, int operation) {
        if (operation == 0) {
            return ((direction + 3) % 4);
        } else if (operation == 1) {
            return ((direction + 1) % 4);
        } else {
            return ((direction + 2) % 4);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] energys = new int[3];

        energys[0] = Integer.parseInt(st.nextToken());
        energys[1] = Integer.parseInt(st.nextToken());
        energys[2] = Integer.parseInt(st.nextToken());
        int totalEnergy = Integer.parseInt(st.nextToken());

        int[][] dp = new int[totalEnergy + 1][4];

        dp[0][1] = -1;
        dp[0][2] = -1;
        dp[0][3] = -1;

        int prevEnergy;
        int curActions;
        int prevActions;

        for (int i = 1; i <= totalEnergy; i++) {
            for (int j = 0; j < 4; j++) {
                curActions = Integer.MAX_VALUE;
                for (int operation = 0; operation < 3; operation++) {
                    prevEnergy = i - energys[operation];
                    if (prevEnergy < 0) {
                        continue;
                    }

                    prevActions = dp[prevEnergy][prevDirection(j, operation)];
                    if (prevActions != -1 && prevActions < curActions) {
                        curActions = prevActions;
                    }
                }

                if (curActions == Integer.MAX_VALUE) {
                    dp[i][j] = -1;
                } else {
                    dp[i][j] = curActions + 1;
                }
            }
        }

        bw.write(dp[totalEnergy][0] + "");

        br.close();
        bw.flush();
        bw.close();
    }

}
