import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _9080 {
    public static int parseTime(String s) {
        int H = Integer.parseInt(s.split(":")[0]);
        int M = Integer.parseInt(s.split(":")[1]);

        return (H * 60) + M;
    }

    public static boolean isDay(int t) {
        return (((t % 1440) < 1320) && ((t % 1440) >= 480));
    }

    public static int ceil(int a, int x){
        if (a % x == 0)
            return a;
        return ((a / x) + 1) * x;
    }

    public static int getNextMorning(int t) {
        if (t % 1440 < 480) {
            return ((t / 1440) * 1440) + 480;
        }
        return (((t / 1440) + 1) * 1440) + 480;
        
    }

    public static int diffHour(int t1, int t2) {
        return ceil(t2 - t1, 60) / 60;
    }

    public static int getMoney(int startT, int endT) {
        int money = 0;

        while (startT < endT) {
            if (isDay(startT)) {
                money += 1000;
                startT += 60;
                continue;
            }

            int nextMorning = getNextMorning(startT);
            
            if (endT <= nextMorning) {
                if (diffHour(startT, endT) >= 5) money += 5000;
                else money += diffHour(startT, endT) * 1000;

                startT = endT;
                break;
            }

            else {
                if (diffHour(startT, nextMorning) > 5) {
                    money += 5000;
                    startT = nextMorning;
                }

                else {
                    while(startT < nextMorning) {
                        money += 1000;
                        startT += 60;
                    }
                }
            }

        }

        return money;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++){
            String[] nums = br.readLine().split(" ");

            int curT = parseTime(nums[0]);
            int duration = Integer.parseInt(nums[1]);

            bw.write(getMoney(curT, curT + duration) + "\n");
        }

        
        br.close();
        bw.flush();
        bw.close();
    }
    
}
