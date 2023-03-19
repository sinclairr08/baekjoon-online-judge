import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class _10172 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = "|\\_/|\n|q p|   /}\n( 0 )\"\"\"\\\n|\"^\"`    |\n||_/=\\\\__|";

        bw.write(s);
        bw.flush();
        bw.close();
    }

}
