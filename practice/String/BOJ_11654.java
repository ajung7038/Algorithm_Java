package practice.String;

import java.io.*;

public class BOJ_11654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String c = br.readLine();

        bw.write(c);

        br.close();
        bw.flush();
        bw.close();
    }
}
