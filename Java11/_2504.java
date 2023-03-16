import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _2504 {
    public static int[] stack = new int[31];
    public static int top = -1;

    public static void push(int N) {
        stack[++top] = N;
    }

    public static int peek() {
        return stack[top];
    }

    public static int pop() {
        return stack[top--];
    }

    public static int calculate(String s) {

        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            if (curChar == '(') {
                push(-1);
            }

            else if (curChar == ')') {
                int tempResult = 0;
                int temp;
                while (top >= 0) {
                    temp = pop();

                    if (temp == -2) {
                        return 0;
                    }

                    if (temp == -1) {
                        push(tempResult == 0 ? 2 : 2 * tempResult);
                        break;
                    }

                    tempResult += temp;
                }

                if (top < 0) {
                    return 0;
                }
            }

            else if (curChar == '[') {
                push(-2);
            }

            else if (curChar == ']') {
                int tempResult = 0;
                int temp;
                while (top >= 0) {
                    temp = pop();

                    if (temp == -1) {
                        return 0;
                    }

                    if (temp == -2) {
                        push(tempResult == 0 ? 3 : 3 * tempResult);
                        break;
                    }

                    tempResult += temp;
                }

                if (top < 0) {
                    return 0;
                }
            }
        }

        int result = 0;

        for (int i = 0; i <= top; i++) {
            if (stack[i] < 0) {
                return 0;
            }
            result += stack[i];
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(calculate(br.readLine()) + "");

        br.close();
        bw.flush();
        bw.close();
    }

}
